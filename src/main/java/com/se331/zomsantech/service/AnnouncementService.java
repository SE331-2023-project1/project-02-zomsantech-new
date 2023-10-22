package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.Announcement;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AnnouncementService {

    Announcement createAnnouncement(Long teacherId, Announcement announcement);

}
