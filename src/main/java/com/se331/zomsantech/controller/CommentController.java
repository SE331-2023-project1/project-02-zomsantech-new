package com.se331.zomsantech.controller;

import com.se331.zomsantech.entity.CommentDTO;
import com.se331.zomsantech.entity.CommentRequest;
import com.se331.zomsantech.service.CommentService;
import com.se331.zomsantech.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDTO> createComment(@RequestParam Long studentId, @RequestParam Long teacherId, @RequestBody CommentRequest request) {
        String content = request.getContent();
        CommentDTO commentDTO = LabMapper.INSTANCE.commentToCommentDTO(commentService.createComment(studentId, teacherId, content));
        if (commentDTO != null) {
            return ResponseEntity.ok(commentDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{commentId}")
    public ResponseEntity<CommentDTO> replyComment(@PathVariable Long commentId,@RequestParam Long studentId,@RequestParam Long teacherId,  @RequestBody CommentRequest request) {
        String content = request.getContent();
        CommentDTO replyDTO = LabMapper.INSTANCE.commentToCommentDTO(commentService.replyComment(studentId, teacherId, commentId, content));
        if (replyDTO != null) {
            return ResponseEntity.ok(replyDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CommentDTO>> getAllCommentsByStudentId(@PathVariable Long studentId) {
        List<CommentDTO> commentsDTO = commentService.getAllCommentsByStudentId(studentId)
                .stream()
                .map(LabMapper.INSTANCE::commentToCommentDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(commentsDTO);
    }
}
