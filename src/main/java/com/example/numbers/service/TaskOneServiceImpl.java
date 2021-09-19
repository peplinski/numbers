package com.example.numbers.service;

import com.example.numbers.controller.repository.TaskOneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskOneServiceImpl implements TaskOneService {

    private final TaskOneRepository taskOneRepository;

    @Override
    public int findMinValue() {
        return taskOneRepository.findMinNumber();
    }

    @Override
    public int findMaxValue() {
        return taskOneRepository.findMaxNumber();
    }

    @Override
    public List<Integer> listDistinctNumbers() {
        return taskOneRepository.findDistinctByNumbers();
    }

    @Override
    public int countDistinctNumbers() {
        return taskOneRepository.countByNumbers();
    }

    @Override
    public int countNumbers() {
        return 0;
    }
}
