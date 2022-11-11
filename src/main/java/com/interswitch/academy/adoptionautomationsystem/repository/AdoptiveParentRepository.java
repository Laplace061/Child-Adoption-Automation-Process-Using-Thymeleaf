package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptiveParent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptiveParentRepository extends JpaRepository<AdoptiveParent,String> {

//    AdoptiveParent findById(int id);
}
