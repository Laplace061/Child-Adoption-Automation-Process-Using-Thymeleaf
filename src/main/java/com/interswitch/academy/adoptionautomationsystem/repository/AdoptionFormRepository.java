package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionForm;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionFormRepository extends JpaRepository<AdoptionForm,String> {

    @Query("SELECT f from AdoptionForm f WHERE " +
            " f.id LIKE CONCAT('%', :text, '%') OR " +
            " f.Witness LIKE CONCAT('%', :text, '%')")
    List<AdoptionForm> searchAdoptionForm(String text);
}
