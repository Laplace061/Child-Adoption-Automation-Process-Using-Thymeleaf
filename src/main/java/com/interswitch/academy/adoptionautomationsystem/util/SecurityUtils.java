package com.interswitch.academy.adoptionautomationsystem.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class SecurityUtils {

    public static User getCurrentUser(){

      Object currentUserInfo = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      if(currentUserInfo instanceof User) {
          return (User) currentUserInfo;
      }
        return null;
    }
}
