package com.se331.zomsantech.dao;

import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class TeacherDaoDbImpl implements TeacherDao {
    final TeacherRepository teacherRepository;
    @Override
    public Integer getTeacherSize() {
        return Math.toIntExact(teacherRepository.count());
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Page<Teacher> getTeachers(String name, Pageable page) {
        return null;
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }
}
