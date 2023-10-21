package com.se331.zomsantech.security.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.se331.zomsantech.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("user_role")
  private List<Role> userRole;

  @JsonProperty("user_username")
  private String userName;

  @JsonProperty("user_id")
  private Integer id;

  @JsonProperty("student_id")
  private Long studentId;

  @JsonProperty("teacher_id")
  private Long teacherId;


//  private OrganizerAuthDTO user;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private ErrorResponse error;


  public static AuthenticationResponse successStudent(String accessToken, String refreshToken, List<Role> userRole, Long studentId) {
    return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .userRole(userRole)
            .studentId(studentId)
            .build();
  }

  public static AuthenticationResponse successTeacher(String accessToken, String refreshToken, List<Role> userRole, Long teacherId) {
    return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .userRole(userRole)
            .teacherId(teacherId)
            .build();
  }

  public static AuthenticationResponse error(ErrorResponse error) {
    return AuthenticationResponse.builder()
            .error(error)
            .build();
  }
}
