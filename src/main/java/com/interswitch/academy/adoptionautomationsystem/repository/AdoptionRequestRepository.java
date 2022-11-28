package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.AdoptionRequest;
import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest,String> {

    @Query("SELECT r from AdoptionRequest  r WHERE " +
            " r.id LIKE CONCAT('%', :text, '%') OR " +
            " r.location LIKE CONCAT('%', :text, '%')")
    List<AdoptionRequest> searchAdoptionRequest(String text);

    @Query("SELECT r.parent from AdoptionRequest r WHERE " + " r.parent.id LIKE (:parentId)")
    Optional<AdoptionRequest> findRequestByParentExists(String parentId);
}
