package com.example.numbers.repository;

import com.example.numbers.model.TaskOneNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskOneRepository extends JpaRepository<TaskOneNumbers,Long> {

    @Query("SELECT min(u.numbers)from TaskOneNumbers u")
    int findMinNumber();

    @Query("SELECT max(u.numbers)from TaskOneNumbers u ")
    int findMaxNumber();

    @Query("SELECT DISTINCT(u.numbers) from TaskOneNumbers u order by u.numbers")
    List<Integer>findDistinctByNumbers();

    @Query("SELECT count (DISTINCT (numbers)) from TaskOneNumbers ")
    int findDistinctByCountNumbers();

}
