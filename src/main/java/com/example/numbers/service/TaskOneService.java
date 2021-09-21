package com.example.numbers.service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TaskOneService {

    int findMinValue();

    int findMaxValue();

    List<Integer> listAllDistinctNumbers();

    int countDistinctNumbers();

    int countNumbers();

    void saveDataFromCsv(MultipartFile file);

}
