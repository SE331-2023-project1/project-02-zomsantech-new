package com.se331.zomsantech.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    Teacher teacher;

    String title;
    String description;
    String date;
    String image;

    @ElementCollection
    @Column(length = 1000)
    List<String> images;


}
