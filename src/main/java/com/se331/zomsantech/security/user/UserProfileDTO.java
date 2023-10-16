package com.se331.zomsantech.security.user;

import lombok.Data;

@Data
public class UserProfileDTO {
    private String username;
    private String firstname;
    private String lastname;
    private String email;
}