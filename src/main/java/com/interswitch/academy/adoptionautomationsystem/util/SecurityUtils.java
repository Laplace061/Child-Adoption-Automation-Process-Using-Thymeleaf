package com.interswitch.academy.adoptionautomationsystem.util;

import com.interswitch.academy.adoptionautomationsystem.entities.User;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;

public class SecurityUtils {

//    private static final Logger logger = LoggerFactory
//            .getLogger(EmployeeController.class);

    public static User getCurrentUser(){

      Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if(principal instanceof User){
          return (User) principal;
      }
      return null;
    }
}
