package com.interswitch.academy.adoptionautomationsystem.entities.enums;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptedChildren;
import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public enum TrackingStatus {

   GREEN("Excellent"),
   YELLOW("Okay"),
   RED("Danger");

   private final String displayValue;

  private TrackingStatus(String displayValue) {
      this.displayValue = displayValue;
   }


}
