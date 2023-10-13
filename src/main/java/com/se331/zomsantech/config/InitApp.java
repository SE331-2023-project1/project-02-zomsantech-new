package com.se331.zomsantech.config;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
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

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Teacher t1, t2, t3;
        t1 = teacherRepository.save(Teacher.builder()
                .name("Dto")
                .surname("Dto").build());
        t2 = teacherRepository.save(Teacher.builder()
                .name("Kong")
                .surname("Passakorn").build());
        t3 = teacherRepository.save(Teacher.builder()
                .name("Tei")
                .surname("Pathathai").build());

        Student tempStudent;

        tempStudent = studentRepository.save(Student.builder()
                .name("Thiwakon")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t1);
        t1.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Sorawee")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t1);
        t1.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Pattanachai")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t2);
        t2.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Taninwat")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t2);
        t2.getOwnStudent().add(tempStudent);

        tempStudent = studentRepository.save(Student.builder()
                .name("Danaikrit")
                .surname("Sakunchao").build());
        tempStudent.setTeacher(t3);
        t3.getOwnStudent().add(tempStudent);

    }
}
