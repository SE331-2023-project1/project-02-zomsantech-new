package com.se331.zomsantech.security.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByTargetUserId(Integer userId);
    List<Comment> findAllByAuthorId(Integer userId);

    List<Comment> findAllByParentCommentId(Integer parentCommentId);

    List<Comment> findAllByTargetUserIdAndParentCommentIsNull(Integer userId);

//    List<Comment> findByTargetUserId(Integer userId);
}
