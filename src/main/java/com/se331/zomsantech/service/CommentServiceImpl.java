package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.Comment;
import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.entity.Teacher;
import com.se331.zomsantech.repository.CommentRepository;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Comment createComment(Long studentId, Long teacherId, String content) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
        // use StudentId as a target to post by and searching for
        // use TeacherId as a author

        if (studentOpt.isPresent() && teacherOpt.isPresent()) {
            Comment comment = Comment.builder()
                    .content(content)
                    .student(studentOpt.get())
                    .teacher(teacherOpt.get())
                    .build();

            return commentRepository.save(comment);
        }

        return null;
    }

    @Override
    public Comment replyComment(Long studentId, Long teacherId,Long commentId, String content) {
        Comment parentComment = commentRepository.findById(commentId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        // teacher for reference in case change advisor
        // student as an reply author

        if (student != null) {
            Comment reply = new Comment();
            reply.setContent(content);
            reply.setParentComment(parentComment);
            reply.setStudent(student);
            reply.setTeacher(teacher);
            return commentRepository.save(reply);
        } else {
            return null;
        }
    }

    @Override
    public List<Comment> getAllCommentsByStudentId(Long studentId) {
        return commentRepository.findAllByStudentId(studentId);
    }
}
