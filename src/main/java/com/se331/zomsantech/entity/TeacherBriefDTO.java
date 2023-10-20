package com.se331.zomsantech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherBriefDTO {
    Long id;
    String username;
    String firstname;
    String lastname;
    String image;
}
