package com.se331.zomsantech.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    Long id;
    String image;
    String username;
    String firstname;
    String lastname;
    @Column(columnDefinition = "json")
    List<String> images;
    String title;
    String description;
    String date;
    String file;
}
