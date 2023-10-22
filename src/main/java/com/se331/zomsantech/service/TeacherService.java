package com.se331.zomsantech.service;

import com.se331.zomsantech.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se331.zomsantech.entity.Teacher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherService {
    Integer getTeachersSize();

    Page<Teacher> getTeachers(Integer pageSize, Integer page);

    Page<Teacher> getTeachers(String title, Pageable pageable);

    Teacher getTeacher(Long id);

    Teacher save(Teacher teacher);

    User updateTeacher(Long id, User updatedUser);
}
