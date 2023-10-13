package com.se331.zomsantech.dao;

import com.se331.zomsantech.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentDao {
    Integer getStudentSize();
    Student save(Student student);
    Page<Student> getStudents(Integer pageSize, Integer page);
    Page<Student> getStudents(String name, Pageable page);
    Student getStudent(Long id);
}
