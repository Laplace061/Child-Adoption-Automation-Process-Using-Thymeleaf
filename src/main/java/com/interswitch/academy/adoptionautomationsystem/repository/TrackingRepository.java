package com.interswitch.academy.adoptionautomationsystem.repository;

import com.interswitch.academy.adoptionautomationsystem.entities.Children;
import com.interswitch.academy.adoptionautomationsystem.entities.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingRepository extends JpaRepository<Tracking,String> {

    @Query("SELECT t from Tracking t WHERE " +
            " t.id LIKE CONCAT('%', :text, '%') OR " +
            " t.location LIKE CONCAT('%', :text, '%') OR " +
            " t.staffAssigned.id LIKE CONCAT('%', :text, '%') OR " +
            "t.child.id LIKE CONCAT('%', :text, '%')")
    List<Tracking> searchTracking(String text);
}
