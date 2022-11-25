package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, String>{

    @Query("SELECT c from Children c WHERE " +
            " c.firstName LIKE CONCAT('%', :text, '%') OR " +
            " c.lastName LIKE CONCAT('%', :text, '%') OR " +
            "c.id LIKE CONCAT('%', :text, '%') OR " +
            "c.fatherName LIKE CONCAT('%', :text, '%') OR " +
            "c.motherName LIKE CONCAT('%', :text, '%') OR " +
            "c.orphanageCode LIKE CONCAT('%', :text, '%') OR " +
            "c.parent.name LIKE CONCAT('%', :text, '%')")
    List<Children> searchChildren(String text);


}
