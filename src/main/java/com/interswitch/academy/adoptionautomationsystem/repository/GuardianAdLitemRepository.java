package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.GuardianAdLitem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuardianAdLitemRepository extends JpaRepository<GuardianAdLitem,String> {

    @Query("SELECT g from GuardianAdLitem g WHERE " +
            " g.id LIKE CONCAT('%', :text, '%') OR " +
            " g.location LIKE CONCAT('%', :text, '%') OR " +
            " g.lastname LIKE CONCAT('%', :text, '%') OR " +
            " g.email LIKE CONCAT('%', :text, '%') OR " +
            " g.phoneNumber LIKE CONCAT('%', :text, '%') OR " +
            "g.firstname LIKE CONCAT('%', :text, '%')")
    List<GuardianAdLitem> searchGuardian(String text);


}
