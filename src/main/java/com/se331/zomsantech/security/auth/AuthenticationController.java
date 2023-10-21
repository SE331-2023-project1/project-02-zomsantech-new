package com.se331.zomsantech.security.auth;

import com.se331.zomsantech.security.user.UserProfileDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping(value = "/register/student", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<AuthenticationResponse> studentRegister(
          @ModelAttribute RegisterRequest request,
          @RequestPart("image") MultipartFile image
  ) throws ServletException, IOException {
    return ResponseEntity.ok(service.studentRegister(request,image));
  }
  @PostMapping(value = "/register/teacher", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<AuthenticationResponse> teacherRegister(
          @ModelAttribute RegisterRequest request,
          @RequestPart("image") MultipartFile image
  ) throws ServletException, IOException {
    return ResponseEntity.ok(service.teacherRegister(request,image));
  }
  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    AuthenticationResponse result = service.authenticate(request);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/profile")
  public ResponseEntity<UserProfileDTO> getProfile() {
    UserProfileDTO profile = service.getCurrentUserProfile();
    return ResponseEntity.ok(profile);
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }


}
