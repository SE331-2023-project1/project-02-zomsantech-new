package com.se331.zomsantech.repository;

import com.se331.zomsantech.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AnnouncementRepository extends JpaRepository<Announcement,Long>{

    List<Announcement> findAll();

//    Announcement findById(Long Id);
}
