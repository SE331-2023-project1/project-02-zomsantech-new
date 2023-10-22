package com.se331.zomsantech.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String username;
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private Long studentUserId;
  private Long teacherUserId;
  private String image;
}
