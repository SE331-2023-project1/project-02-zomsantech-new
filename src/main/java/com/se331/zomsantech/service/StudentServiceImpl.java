package com.se331.zomsantech.service;

import com.se331.zomsantech.dao.StudentDao;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.StudentDTO;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    private final StudentRepository studentRepository;
    @Override
    public Integer getStudentsSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public List<Student> getStudents(Integer pageSize, Integer page) {
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

    @Override
    public User findUserByStudentId(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::getUser)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }
}
