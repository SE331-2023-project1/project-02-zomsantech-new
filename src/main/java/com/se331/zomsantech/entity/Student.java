package com.se331.zomsantech.entity;

import com.se331.zomsantech.security.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    @ElementCollection
    List<String> images;
    String department;
    @ManyToOne
    Teacher teacher;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
