package com.se331.zomsantech.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super("Student with ID " + id + " not found");
    }
}