package com.se331.zomsantech.controller;

import com.se331.zomsantech.security.user.Comment;
import com.se331.zomsantech.security.user.CommentDTO;
import com.se331.zomsantech.security.user.CommentService;
import com.se331.zomsantech.security.user.User;
import com.se331.zomsantech.service.StudentService;
import com.se331.zomsantech.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create/{studentUserId}")
    public ResponseEntity<?> addComment(@PathVariable("studentUserId") Long studentUserId, @RequestBody Comment comment) {
        User targetUser = studentService.findUserByStudentId(studentUserId);
        comment.setTargetUser(targetUser);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(commentService.addComment(comment)));
    }

    @GetMapping("/target/{studentUserId}")
    public ResponseEntity<?> getCommentsForUser(@PathVariable("studentUserId") Long studentUserId) {
        List<Comment> comments = commentService.getCommentsForStudent(studentUserId);
        List<CommentDTO> commentDTOs = LabMapper.INSTANCE.getCommentDTO(comments);
        return ResponseEntity.ok(commentDTOs);
    }

    @PostMapping("/reply/{commentId}")
    public ResponseEntity<?> replyToComment(@PathVariable("commentId") Integer commentId, @RequestBody Comment reply) {
        Comment savedReply = commentService.replyToComment(commentId, reply);
        CommentDTO savedReplyDTO = LabMapper.INSTANCE.getCommentDTO(savedReply);
        return ResponseEntity.ok(savedReplyDTO);
    }
}