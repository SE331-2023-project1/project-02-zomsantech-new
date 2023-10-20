package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.security.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.se331.zomsantech.entity.Student;

public interface StudentService {
    Integer getStudentsSize();

    Page<Student> getStudents(Integer pageSize, Integer page);

    Page<Student> getStudents(String filter, Pageable pageable);

    Student getStudent(Long id);

    Student save(Student student);

    User updateStudent(Long id, User user);
}
