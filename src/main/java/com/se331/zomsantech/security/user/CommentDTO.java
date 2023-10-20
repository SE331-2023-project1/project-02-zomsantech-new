package com.se331.zomsantech.security.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    Integer id;
    String content;
    UserDTO author;
    UserDTO targetUser;
    List<CommentDTO> replies;
}
