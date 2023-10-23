package com.se331.zomsantech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    Long id;
    String content;
    CommentDTO reply;

    Long teacherId;
    String teacherImage;
    String teacherFirstName;

    Long studentId;
    String studentImage;
    String studentFirstName;


}
