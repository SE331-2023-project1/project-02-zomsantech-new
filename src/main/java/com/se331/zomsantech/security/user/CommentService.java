package com.se331.zomsantech.security.user;

import com.se331.zomsantech.entity.Student;
import com.se331.zomsantech.repository.StudentRepository;
import com.se331.zomsantech.util.LabMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StudentRepository studentRepository;



    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsForStudent(Long studentId) {
        // หา student จาก studentId
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (!optionalStudent.isPresent()) {
            return new ArrayList<>();
        }

        User user = optionalStudent.get().getUser();

        List<Comment> allComments = commentRepository.findByTargetUserId(user.getId());

        Map<Integer, Comment> commentMap = new HashMap<>();

        for (Comment comment : allComments) {
            if (comment.getParentComment() == null) {
                // Main comment
                commentMap.put(comment.getId(), comment);
                comment.setReplies(new ArrayList<>());
            } else {
                // Reply comment
                Comment parentComment = commentMap.get(comment.getParentComment().getId());
                if (parentComment != null) {
                    parentComment.getReplies().add(comment);
//                    commentMap.remove(comment.getParentComment().getId());
                }
            }
        }

        return new ArrayList<>(commentMap.values());
    }









    public Comment replyToComment(Integer commentId, Comment reply) {
        Comment parentComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        reply.setParentComment(parentComment);
        return commentRepository.save(reply);
    }
}





