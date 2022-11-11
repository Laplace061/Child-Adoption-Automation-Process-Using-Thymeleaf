package com.interswitch.academy.adoptionautomationsystem.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdUtil {

        public String generateId(){
            return UUID.randomUUID().toString();

    }

//    public String trimLocation(String location){
//
//        String locations = location.trim().toLowerCase();
//        String userid = locations.substring(0,3);
//        String id = userid.concat(String.valueOf(new Date()));
//        return id;
//
//    }
}
