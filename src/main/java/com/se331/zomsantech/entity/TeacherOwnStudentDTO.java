package com.se331.zomsantech.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherOwnStudentDTO {
    Long id;
    String name;
    String surname;
    String image;
}
