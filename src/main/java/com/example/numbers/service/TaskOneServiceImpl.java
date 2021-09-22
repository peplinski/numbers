package com.example.numbers.service;

import com.example.numbers.model.TaskOneNumbers;
import com.example.numbers.repository.TaskOneRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskOneServiceImpl implements TaskOneService {

    private final TaskOneRepository taskOneRepository;
    TaskOneNumbers taskNumber;

    @Override
    public int findMinValue() {
        return taskOneRepository.findMinNumber();
    }

    @Override
    public int findMaxValue() {
        return taskOneRepository.findMaxNumber();
    }

    @Override
    public List<Integer> listAllDistinctNumbers() {
        return taskOneRepository.findDistinctByNumbers();
    }

    @Override
    public int countDistinctNumbers() {
        return taskOneRepository.findDistinctByCountNumbers();
    }

    @Override
    public int countNumbers() {
        return (int) taskOneRepository.count();
    }

    @Override
    public void saveDataFromCsv(MultipartFile file) {
        List<TaskOneNumbers> taskOneNumbers =new ArrayList<>();

        try{
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(','));
            for (CSVRecord record: csvParser){
                taskNumber = new TaskOneNumbers();
                taskNumber.setNumbers(Integer.parseInt(record.get(0)));
               taskOneNumbers.add(taskNumber);
            }
            taskOneRepository.saveAll(taskOneNumbers);
            csvParser.close();
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
