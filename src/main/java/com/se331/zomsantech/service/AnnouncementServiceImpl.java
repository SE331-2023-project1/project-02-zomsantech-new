package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.Announcement;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.exception.ResourceNotFoundException;
import com.se331.zomsantech.repository.AnnouncementRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.util.CloudStorageHelper;
import jakarta.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Announcement createAnnouncement(Long teacherId, Announcement announcement) {
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);

        announcement.setTeacher(teacherOpt.get());
//        announcement.setFile(announcement.getFile());

        return announcementRepository.save(announcement);
    }

}
