package com.example.numbers.repository;

import com.example.numbers.model.Task2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Task2Repository extends JpaRepository<Task2,Long> {


    @Query("select numbers from Task2")
    List<Integer> findNumbers(int sum);
}
