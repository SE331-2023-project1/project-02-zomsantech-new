package com.se331.zomsantech.config;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;

//    public InitApp(UserRepository userRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//        this.teacherRepository = teacherRepository;
//    }

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        User userT1 = new User();
        userT1.setUsername("teacherDto");
        userT1.setPassword("teacherDtoPassword");
        userRepository.save(userT1);

        Teacher t1 = new Teacher();
        t1.setUser(userT1);
        teacherRepository.save(t1);

        User userT2 = new User();
        userT1.setUsername("teacherDtoasddd");
        userT1.setPassword("teacherDtoPassasdddword");
        userRepository.save(userT2);

        Teacher t2 = new Teacher();
        t2.setUser(userT2);
        teacherRepository.save(t2);

        User userS1 = new User();
        userS1.setUsername("studentThiwakon");
        userS1.setPassword("studentThiwakonPassword");
        userRepository.save(userS1);

        Student s1 = new Student();
        s1.setUser(userS1);
        s1.setTeacher(t1);
        studentRepository.save(s1);



//        Teacher t1, t2, t3;
//        // Teacher from entity
//        t1 = teacherRepository.save(Teacher.builder()
//                .name("Dto")
//                .surname("Dto").build());
//        t2 = teacherRepository.save(Teacher.builder()
//                .name("Kong")
//                .surname("Passakorn").build());
//        t3 = teacherRepository.save(Teacher.builder()
//                .name("Tei")
//                .surname("Pathathai").build());
//
//        Student tempStudent;
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Thiwakon")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t1);
//        t1.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Sorawee")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t1);
//        t1.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Pattanachai")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t2);
//        t2.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Taninwat")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t2);
//        t2.getOwnStudent().add(tempStudent);
//
//        tempStudent = studentRepository.save(Student.builder()
//                .name("Danaikrit")
//                .surname("Sakunchao").build());
//        tempStudent.setTeacher(t3);
//        t3.getOwnStudent().add(tempStudent);

    }
}
