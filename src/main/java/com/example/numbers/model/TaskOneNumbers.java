package com.example.numbers.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task_numbers")
public class TaskOneNumbers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int numbers;

}
