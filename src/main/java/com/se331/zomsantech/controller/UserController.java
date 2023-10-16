package com.se331.zomsantech.controller;

import com.se331.zomsantech.entity.DetailedTeacherDTO;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserRepository;
import com.se331.zomsantech.security.user.UserService;
import com.se331.zomsantech.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository; // ถ้าคุณมี TeacherRepository

    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(users));
    }

    @GetMapping("/students")
    public ResponseEntity<?> getUsersThatAreStudents() {
        List<Student> students = studentRepository.findAll();
        List<User> studentUsers = students.stream().map(Student::getUser).collect(Collectors.toList());
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(studentUsers));
    }

//    @GetMapping("/teachers")
//    public ResponseEntity<?> getUsersThatAreTeachers() {
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<User> teacherUsers = teachers.stream().map(Teacher::getUser).collect(Collectors.toList());
//        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(teacherUsers));
//    }
@GetMapping("/teachers")
public ResponseEntity<?> getAllTeachers() {
    List<Teacher> teachers = teacherRepository.findAll();
    List<DetailedTeacherDTO> detailedTeacherDTOs = teachers.stream()
            .map(LabMapper.INSTANCE::getDetailedTeacherDTO)
            .collect(Collectors.toList());
    return ResponseEntity.ok(detailedTeacherDTOs);
}

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(user));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

//    @GetMapping("users/teachers")
//    public ResponseEntity<?> getAllTeachers() {
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<User> teacherUsers = teachers.stream().map(Teacher::getUser).collect(Collectors.toList());
//        return ResponseEntity.ok(teacherUsers);
//    }
}