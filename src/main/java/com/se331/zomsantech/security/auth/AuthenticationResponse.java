package com.se331.zomsantech.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.OrganizerAuthDTO;
import se331.lab.rest.entity.OrganizerDTO;
import se331.lab.rest.security.user.Role;

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
//  private OrganizerAuthDTO user;
}
