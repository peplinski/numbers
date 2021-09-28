package com.example.numbers.model;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task_two")
public class Task2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int numbers;

    @Transient
    MultipartFile file;
}
