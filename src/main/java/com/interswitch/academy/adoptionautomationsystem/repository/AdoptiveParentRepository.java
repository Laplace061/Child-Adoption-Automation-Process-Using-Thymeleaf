package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptiveParentRepository extends JpaRepository<AdoptiveParent,String> {

    @Query("SELECT p from AdoptiveParent p WHERE " +
            " p.id LIKE CONCAT('%', :text, '%') OR " +
            " p.name LIKE CONCAT('%', :text, '%') OR " +
            " p.occupation LIKE CONCAT('%', :text, '%') OR " +
            " p.phoneNumber LIKE CONCAT('%', :text, '%')")
    List<AdoptiveParent> searchAdoptiveParent(String text);

    AdoptiveParent findAdoptiveParentByName(String name);

}
