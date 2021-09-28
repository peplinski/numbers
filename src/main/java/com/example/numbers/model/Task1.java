package com.example.numbers.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task_numbers")
public class Task1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "task1_numbers")
    int numbers;

    @Transient
    MultipartFile file;
}
