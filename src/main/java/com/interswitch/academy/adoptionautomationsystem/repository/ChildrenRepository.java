package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Query("SELECT c.parent from Children c WHERE " + " c.parent.id LIKE (:parentId)")
    Optional<Children> findChildrenByParentExists(String parentId);

    List<Children> findChildrenByGuardianId(String guardianId);

    Children findChildByParentId(String parentId);


}
