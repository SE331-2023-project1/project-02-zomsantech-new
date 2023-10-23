package com.se331.zomsantech.controller;

import com.se331.zomsantech.dao.StudentDao;
import com.se331.zomsantech.entity.DetailedTeacherDTO;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.exception.StudentNotFoundException;
import com.se331.zomsantech.exception.TeacherNotFoundException;
import com.se331.zomsantech.exception.UserNotFoundException;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    private final TeacherRepository teacherRepository;

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final UserService userService;



    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(users));
    }

    @GetMapping("/students")
    public ResponseEntity<?> getAllStudents(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "_filter", required = false) String filter,
                                            @RequestParam(value = "_haveNoTeacher", required = false) Boolean haveNoTeacher) {
        perPage = perPage == null ? 20 : perPage;
        page = page == null ? 1 : page;
        Page<Student> pageOutput;

        Long idFilter = null;
        if (filter != null && filter.matches("\\d+")) {
            idFilter = Long.parseLong(filter);
        }


        if (idFilter != null) {
            pageOutput = studentRepository.findById(idFilter,PageRequest.of(page - 1, perPage) );
        } else if (filter != null) {
            pageOutput = studentService.getStudents(filter, PageRequest.of(page - 1, perPage));
        } else {
            pageOutput = studentService.getStudents(perPage, page);
        }

        if (haveNoTeacher != null) {
            pageOutput = studentService.getStudentTeacherIsNull(perPage, page);
        }

        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent().stream()
                .map(LabMapper.INSTANCE::getStudentDTO)
                .collect(Collectors.toList()), responseHeader, HttpStatus.OK);

    }

    @PutMapping("/relation")
    public ResponseEntity<?> changeRelation(@RequestParam(value = "teacherId") Integer teacherId,
                                            @RequestParam(value = "studentId") Integer studentId) {
        ;
    return ResponseEntity.ok(LabMapper.INSTANCE.getTeacherDTO(teacherService.addStudent(studentId,teacherId)));
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Student studentopt = studentService.getStudent(id);
        if (studentopt == null) {
            throw new StudentNotFoundException(id);
        }
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(studentopt));
    }


    @PutMapping(value = "/students/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id,
                                           @RequestBody User user) {
        User updatedUser = studentService.updateStudent(id, user);
        if (updatedUser == null) {
            throw new UserNotFoundException(id);
        } else {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(updatedUser));
        }
    }


    @GetMapping("/teachers")
    public ResponseEntity<?> getAllTeachers(@RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "_filter", required = false) String filter) {
        perPage = perPage == null ? 20 : perPage;
        page = page == null ? 1 : page;
        Page<Teacher> pageOutput;

        Long idFilter = null;
        if (filter != null && filter.matches("\\d+")) {
            idFilter = Long.parseLong(filter);
        }

        if (idFilter != null) {
            pageOutput = teacherRepository.findById(idFilter,PageRequest.of(page - 1, perPage) );
        }
        else if (filter != null) {
            pageOutput = teacherService.getTeachers(perPage, page);
        } else {
            pageOutput = teacherService.getTeachers(filter, PageRequest.of(page - 1, perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(pageOutput.getContent().stream()
                .map(LabMapper.INSTANCE::getDetailedTeacherDTO)
                .collect(Collectors.toList()), responseHeader, HttpStatus.OK);


    }

    @GetMapping("/teachers/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getTeacherById(@PathVariable("id") Long id) {
        Teacher teacherOpt = teacherService.getTeacher(id);

        if (teacherOpt == null) {
            throw new TeacherNotFoundException(id);
        } else {
            return ResponseEntity.ok(LabMapper.INSTANCE.getDetailedTeacherDTO(teacherOpt));
        }

    }

    @PutMapping(value = "/teachers/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateTeacher(@PathVariable("id") Long id,
                                           @RequestBody User user
                                          ) {
        User updatedUser = teacherService.updateTeacher(id, user);
        if (updatedUser == null) {
            throw new UserNotFoundException(id);
        } else {
            return ResponseEntity.ok(LabMapper.INSTANCE.getUserDTO(updatedUser));
        }
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


}