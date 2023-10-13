package com.se331.zomsantech.config;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        studentRepository.save(Student.builder()
                .name("Thiwakon")
                .surname("Sakunchao").build());
        studentRepository.save(Student.builder()
                .name("Sorawee")
                .surname("Sakunchao").build());
        studentRepository.save(Student.builder()
                .name("Pattanachai")
                .surname("Sakunchao").build());
    }
}
