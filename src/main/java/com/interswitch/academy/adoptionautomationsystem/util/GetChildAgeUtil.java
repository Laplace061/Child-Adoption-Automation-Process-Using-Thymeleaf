package com.interswitch.academy.adoptionautomationsystem.util;

import org.springframework.stereotype.Service;

import java.time.*;
import java.util.Date;

@Service
public class GetChildAgeUtil {

    //Getting the child age from the Birthdate

    public int getChildAge(Date date){

        //Converting obtained Date object to LocalDate object
        Instant instant = date.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate givenDate = zone.toLocalDate();
        //Calculating the difference between given date to current date.
        Period period = Period.between(givenDate, LocalDate.now());
        System.out.print("Age in years is :" + period.getYears() + " years " + "Age in months is :" + period.getMonths()+" and age in days is " + period.getDays()+" days");
        int age =period.getYears();

        return age;
    }
}



/*        If age is in String we need to first convert it to Java Util date and pass the return to the method above

   public static Date StringToDate(String dob) throws ParseException{

      //Instantiating the SimpleDateFormat class if age is coming as string

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                //Parsing the given String to Date object

       Date date = formatter.parse(dob);
       System.out.println("Date object value: "+date);
       return date;
   }
 */