package com.example.numbers.service;

import java.util.List;

public interface TaskOneService {

    int findMinValue();

    int findMaxValue();

    List<Integer> listDistinctNumbers();

    int countDistinctNumbers();

    int countNumbers();
}
