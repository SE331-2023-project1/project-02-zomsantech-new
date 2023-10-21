package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se331.zomsantech.entity.Student;

import java.util.List;

public interface StudentService {
    Integer getStudentsSize();

    List<Student> getStudents(Integer pageSize, Integer page);

    Page<Student> getStudents(String filter, Pageable pageable);

    Student getStudent(Long id);

    Student save(Student student);

    User updateStudent(Long id, User user);

    User findUserByStudentId(Long studentUserId);
}
