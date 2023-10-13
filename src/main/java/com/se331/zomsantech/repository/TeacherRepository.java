package com.se331.zomsantech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se331.zomsantech.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAll();
}
