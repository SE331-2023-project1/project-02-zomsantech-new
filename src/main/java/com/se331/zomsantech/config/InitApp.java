package com.se331.zomsantech.config;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import com.se331.zomsantech.security.user.Role;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User admin = new User();
        admin.setUsername("admin");
        admin.setFirstname("admin");
        admin.setLastname("admin");
        admin.setPassword(encoder.encode("admin"));
        admin.setEmail("admin@admin.com");
        admin.setRoles(List.of(Role.ROLE_ADMIN));
        userRepository.save(admin);

        User userT1 = new User();
        userT1.setUsername("MM");
        userT1.setFirstname("Mr. Mock");
        userT1.setLastname("Kingbird");
        userT1.setPassword("password");
        userT1.setRoles(List.of(Role.ROLE_TEACHER));
        userRepository.save(userT1);

        User userT2 = new User();
        userT2.setUsername("SS");
        userT2.setFirstname("Solid State");
        userT2.setLastname("Of America");
        userT2.setPassword("passasdword");
        userT2.setRoles(List.of(Role.ROLE_TEACHER));
        userRepository.save(userT2);


        Teacher t1 = new Teacher();
        t1.setUser(userT1);
        teacherRepository.save(t1);

        User userS1 = new User();
        userS1.setUsername("Thiwakon");
        userS1.setFirstname("Solid State");
        userS1.setLastname("Of America");
        userS1.setPassword("passwasdord");
        userS1.setRoles(List.of(Role.ROLE_STUDENT));
        userRepository.save(userS1);

        User userS2 = new User();
        userS2.setUsername("Pat");
        userS2.setFirstname("Pattana");
        userS2.setLastname("Pattana");
        userS2.setPassword("passwasdord");
        userS2.setRoles(List.of(Role.ROLE_STUDENT));
        userRepository.save(userS2);

        Student s1 = new Student();
        s1.setUser(userS1);
        s1.setTeacher(t1);
        studentRepository.save(s1);

        Teacher t2 = new Teacher();

        Student s2 = new Student();

        s2.setUser(userS2);
        s2.setTeacher(t2);
        studentRepository.save(s2);

        t2.setUser(userT2);
        t2.getOwnStudent().add(s2);
        s2.setTeacher(t2);
        teacherRepository.save(t2);
        studentRepository.save(s2);


    }
}
