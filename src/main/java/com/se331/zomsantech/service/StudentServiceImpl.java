package com.se331.zomsantech.service;

import com.se331.zomsantech.dao.StudentDao;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    @Override
    public Integer getStudentsSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Page<Student> getStudents(String filter, Pageable pageable) {
        return studentDao.getStudents(filter,pageable);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public User updateStudent(Long id, User user) {
        return studentDao.updateStudent(id, user);
    }

}
