//package com.se331.zomsantech.controller;
//
//import com.se331.zomsantech.security.user.Comment;
//import com.se331.zomsantech.security.user.CommentDTO;
//import com.se331.zomsantech.security.user.CommentService;
//import com.se331.zomsantech.security.user.User;
//import com.se331.zomsantech.service.StudentService;
//import com.se331.zomsantech.util.LabMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/comments")
//public class CommentController {
//
//    @Autowired
//    private CommentService commentService;
//
//    private StudentService studentService;  // ใช้ StudentService ในการค้นหา Student และ User
//
//    @PostMapping("/create/{studentUserId}")
//    public ResponseEntity<?> addComment(@PathVariable Long studentUserId, @RequestBody Comment comment) {
//        User targetUser = studentService.findUserByStudentId(studentUserId);
//        comment.setTargetUser(targetUser);
//        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(commentService.addComment(comment)));
//    }
//
//    // ใช้ studentUserId ในการค้นหา comments
//    @GetMapping("/target/{studentUserId}")
//    public ResponseEntity<?> getCommentsForUser(@PathVariable Long studentUserId) {
//        User targetUser = studentService.findUserByStudentId(studentUserId);
//        return ResponseEntity.ok(commentService.getCommentsForUser(targetUser.getId()));
//    }
//
//    @PostMapping("/reply/{commentId}")
//    public Comment replyToComment(@PathVariable("commentId") Integer commentId, @RequestBody Comment reply) {
//        return commentService.replyToComment(commentId, reply);
//    }
//}