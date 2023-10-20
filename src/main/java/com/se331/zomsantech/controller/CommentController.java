package com.se331.zomsantech.controller;

import com.se331.zomsantech.security.user.Comment;
import com.se331.zomsantech.security.user.CommentDTO;
import com.se331.zomsantech.security.user.CommentService;
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

    @PostMapping("/create")
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {

        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(commentService.addComment(comment)));
    }

//    @GetMapping("/target/{userId}")
//    public ResponseEntity<?> getCommentsForUser(@PathVariable Integer userId) {
//        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(commentService.getCommentsForUser(userId));
//    }


    @PostMapping("/reply/{commentId}")
    public Comment replyToComment(@PathVariable("commentId") Integer commentId, @RequestBody Comment reply) {
        return commentService.replyToComment(commentId, reply);
    }

//    @GetMapping("/replies/{commentId}")
//    public List<Comment> getRepliesForComment(@PathVariable Integer commentId) {
//        return commentService.getRepliesForComment(commentId);
//    }
}