//package com.se331.zomsantech.security.user;
//
//import com.se331.zomsantech.util.LabMapper;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class CommentService {
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @Autowired
//    private LabMapper labMapper;
//
//    public Comment addComment(Comment comment) {
//        System.out.println(comment);
//        return commentRepository.save(comment);
//    }
//
//    public List<CommentDTO> getCommentsForUser(Integer userId) {
//        List<Comment> mainComments = commentRepository.findByTargetUserIdAndParentCommentIsNull(userId);
//
//        List<CommentDTO> result = new ArrayList<>();
//        for (Comment mainComment : mainComments) {
//            List<Comment> replies = commentRepository.findByParentCommentId(mainComment.getId());
//            CommentDTO dto = new CommentDTO(mainComment, replies);
//            result.add(dto);
//        }
//
//        return result;
//    }
//
//    public Comment replyToComment(Integer commentId, Comment reply) {
//        Comment parentComment = commentRepository.findById(commentId)
//                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
//
//        reply.setParentComment(parentComment);
//        return commentRepository.save(reply);
//    }
//}
//
//
//
//
//
