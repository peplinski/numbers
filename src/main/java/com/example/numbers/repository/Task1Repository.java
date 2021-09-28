package com.example.numbers.repository;

import com.example.numbers.model.Task1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Task1Repository extends JpaRepository<Task1,Long> {

    @Query("SELECT min(u.numbers)from Task1 u")
    int findMinNumber();

    @Query("SELECT max(u.numbers)from Task1 u ")
    int findMaxNumber();

    @Query("SELECT DISTINCT(u.numbers) from Task1 u order by u.numbers")
    List<Integer>findDistinctByNumbers();

    @Query("SELECT count (DISTINCT (numbers)) from Task1 ")
    int findDistinctByCountNumbers();

}
