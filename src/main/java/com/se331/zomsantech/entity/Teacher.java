package com.se331.zomsantech.entity;

import com.se331.zomsantech.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    @ElementCollection
    List<String> images;
    String department;
    @OneToMany(mappedBy = "teacher")
    @Builder.Default
    List<Student> ownStudent = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
