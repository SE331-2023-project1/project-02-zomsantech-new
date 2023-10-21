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
//        List<Comment> allComments = commentRepository.findByTargetUserId(userId);
//
//        Map<Integer, CommentDTO> commentMap = new HashMap<>();
//
//        for (Comment comment : allComments) {
//            if (comment.getParentComment() == null) {
//                // Main comment
//                CommentDTO dto = convertToDTO(comment);
//                dto.setReplies(new ArrayList<>());
//                commentMap.put(comment.getId(), dto);
//            } else {
//                // Reply comment
//                CommentDTO parentDto = commentMap.get(comment.getParentComment().getId());
//                if (parentDto != null) {
//                    CommentDTO replyDto = convertToDTO(comment);
//                    parentDto.getReplies().add(replyDto);
//                    commentMap.remove(comment.getParentComment().getId());
//                }
//            }
//        }
//
//        return new ArrayList<>(commentMap.values());
//    }
//
//
//
//
//
//
//
//
//
//
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
