package com.example.numbers.controller.repository;

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

    @Query("select distinct(u.numbers) from TaskOneNumbers u order by u.numbers")
    List<Integer>findDistinctByNumbers();

    @Query("select count (distinct (numbers)) from TaskOneNumbers ")
    int findDistinctByCountNumbers();

//    @Query("select count(numbers) from  TaskOneNumbers ")
//    int countByNumbers();

}
