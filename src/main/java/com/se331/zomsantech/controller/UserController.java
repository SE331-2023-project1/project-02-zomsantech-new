package com.se331.zomsantech.controller;

import com.se331.zomsantech.entity.DetailedTeacherDTO;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserRepository;
import com.se331.zomsantech.security.user.UserService;
import com.se331.zomsantech.service.StudentService;
import com.se331.zomsantech.service.TeacherService;
import com.se331.zomsantech.util.LabMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final TeacherRepository teacherRepository; // ถ้าคุณมี TeacherRepository

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final UserService userService;
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(users));
    }

    @GetMapping("/students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {




//        List<Student> students = studentRepository.findAll();
//        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
//        List<User> studentUsers = students.stream().map(Student::getUser).collect(Collectors.toList());
//        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(studentUsers));
        return ResponseEntity.ok("hi");
    }

//    @GetMapping("/teachers")
//    public ResponseEntity<?> getUsersThatAreTeachers() {
//        List<Teacher> teachers = teacherRepository.findAll();
//        List<User> teacherUsers = teachers.stream().map(Teacher::getUser).collect(Collectors.toList());
//        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(teacherUsers));
//    }
@GetMapping("/teachers")
public ResponseEntity<?> getAllTeachers(@RequestParam(value = "_limit", required = false) Integer perPage,
                                        @RequestParam(value = "_page", required = false) Integer page,
                                        @RequestParam(value = "_filter", required = false) String filter) {
    perPage = perPage == null ? 3 : perPage;
    page = page == null ? 1 : page;
    Page<Teacher> pageOutput;
    // = teacherService.getTeachers(perPage, page);

            if (filter == null) {
                pageOutput = teacherService.getTeachers(perPage, page);
//                    pageOutput = eventService.getEvents(perPage,page);
                }else{
                    pageOutput = teacherService.getTeachers(filter, PageRequest.of(page-1,perPage));
               }


    HttpHeaders responseHeader = new HttpHeaders();
    responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
    return new ResponseEntity<>(pageOutput.getContent().stream()
            .map(LabMapper.INSTANCE::getDetailedTeacherDTO)
            .collect(Collectors.toList()), responseHeader, HttpStatus.OK);
}

    @GetMapping("/teachers/{id}")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") Long id) {
        Teacher teacherOpt = teacherService.getTeacher(id);
        return ResponseEntity.ok(LabMapper.INSTANCE.getDetailedTeacherDTO(teacherOpt));

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