package com.se331.zomsantech.repository;

import java.util.List;

import com.se331.zomsantech.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.se331.zomsantech.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Page<Student> findByUser_FirstnameIgnoreCaseContainingOrUser_LastnameIgnoreCaseContainingOrUser_UsernameIgnoreCaseContaining(String firstname, String lastname, String username, Pageable pageRequest);

}
