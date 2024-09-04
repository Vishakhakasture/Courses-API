package com.example.course_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Instance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instance_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // Assuming you have a Course entity

    private String title;
    private String course_code;
    private int year;
    private int semester;
    private int id;
}
