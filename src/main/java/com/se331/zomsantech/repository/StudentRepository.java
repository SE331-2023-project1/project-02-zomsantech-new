package com.se331.zomsantech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se331.zomsantech.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
}
