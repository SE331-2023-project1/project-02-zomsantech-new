package com.se331.zomsantech.service;

import com.se331.zomsantech.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment createComment(Long studentId, Long teacherId, String content);
    Comment replyComment(Long studentId, Long teacherId,Long commentId, String content);
    List<Comment> getAllCommentsByStudentId(Long studentId);
}