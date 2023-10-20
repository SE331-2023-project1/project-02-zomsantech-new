package com.se331.zomsantech.security.user;

import com.se331.zomsantech.util.LabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment addComment(Comment comment) {
        System.out.println(comment);
        return commentRepository.save(comment);
    }

    public List<Comment> getRepliesForComment(Integer commentId) {
        return commentRepository.findAllByParentCommentId(commentId);
    }

    private LabMapper labMapper;

    public List<CommentDTO> getCommentsForUser(Integer userId) {
        List<Comment> mainComments = commentRepository.findAllByTargetUserIdAndParentCommentIsNull(userId);

        List<CommentDTO> result = new ArrayList<>();
        for (Comment mainComment : mainComments) {
            List<Comment> replies = commentRepository.findAllByParentCommentId(mainComment.getId());
            CommentDTO dto = labMapper.getCommentDTO(mainComment);
            dto.setReplies(labMapper.getCommentDTO(replies));  // set replies using LabMapper
            result.add(dto);
        }

        return result;
    }

    public List<Comment> getCommentsByUser(Integer userId) {
        return commentRepository.findAllByAuthorId(userId);
    }

    public Comment replyToComment(Integer commentId, Comment reply) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        reply.setParentComment(parentComment);
        return commentRepository.save(reply);
    }
}
