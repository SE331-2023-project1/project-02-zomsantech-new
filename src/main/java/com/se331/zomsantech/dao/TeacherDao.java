package com.se331.zomsantech.dao;

import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TeacherDao {
    Integer getTeacherSize();
    Teacher save(Teacher teacher);
    List<Teacher> getTeachers(Integer pageSize, Integer page);
    Page<Teacher> getTeachers(String name, Pageable page);
    Teacher getTeacher(Long id);

    User updateTeacher(Long id, User updatedUser);
}
