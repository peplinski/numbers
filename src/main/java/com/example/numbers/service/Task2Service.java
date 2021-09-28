package com.example.numbers.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface Task2Service {
    void readDataFromCsv(MultipartFile file);
    List<String> findSum(int sum);
}
