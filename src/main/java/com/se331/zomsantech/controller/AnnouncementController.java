package com.se331.zomsantech.controller;

import com.se331.zomsantech.entity.*;
import com.se331.zomsantech.repository.AnnouncementRepository;
import com.se331.zomsantech.service.AnnouncementService;
import com.se331.zomsantech.util.CloudStorageHelper;
import com.se331.zomsantech.util.LabMapper;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1/announcements")
public class AnnouncementController {

    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Autowired
    private AnnouncementService announcementService;

    @Autowired
    private AnnouncementRepository announcementRepository;

    public AnnouncementController() {
    }

    @PostMapping
    public ResponseEntity<AnnouncementDTO> createAnnouncement(@RequestParam("teacherId") Long teacherId, @ModelAttribute Announcement announcement, @RequestPart("files") MultipartFile files) {
        AnnouncementDTO announcementDTO = LabMapper.INSTANCE.getAnnouncementDTO(announcementService.createAnnouncement(teacherId, announcement, files));
        return ResponseEntity.ok(announcementDTO);

    }
}
