package com.interswitch.academy.adoptionautomationsystem.controller;

import com.interswitch.academy.adoptionautomationsystem.dto.RegistrationDto;
import com.interswitch.academy.adoptionautomationsystem.entities.User;
import com.interswitch.academy.adoptionautomationsystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }

    // handler method to handle user registration request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // this object holds form data
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user") RegistrationDto user,
                           BindingResult result,
                           Model model){
        User existingUser = userService.findByEmail(user.getEmail());
        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null, "There is already a user with same email id");
        }

        if(result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String loginForm() {

        return "login";
    }

    @GetMapping("/render/user/page")
    public String returnUserPage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String obj = auth.getName();
        log.info(obj);
        User dbUser = userService.findByEmail(obj);
//        System.out.println(dbUser.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        if(dbUser.getRoles().stream().anyMatch(role -> role.getName().equalsIgnoreCase("ROLE_SYSADMIN"))){
            model.addAttribute("Users",dbUser);
            return "/sysadmin/sysadmin dashboard";
        }else if(dbUser.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"))){
//            model.addAttribute("allUsers",dbUser);
            return "/admin/dashboard";
        }else
//            model.addAttribute("allUsers",dbUser);
        return "/admin/dashboard";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model){

        List<RegistrationDto> users = userService.findAllUsers();
        model.addAttribute("allUsers", users);
        return "admin/allUsers";
    }

    @GetMapping("/admin/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") String userId){
        this.userService.deleteUser(userId);
        return "redirect:/admin/dashboard";
    }
}
