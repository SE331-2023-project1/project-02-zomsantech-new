package com.se331.zomsantech.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("students")
    public ResponseEntity<?> getStudentsList() {
        HttpHeaders responseHeader = new HttpHeaders();
        return ResponseEntity.ok("success");

    }
}
