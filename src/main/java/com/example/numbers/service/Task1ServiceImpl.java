package com.example.numbers.service;

import com.example.numbers.model.Task1;
import com.example.numbers.repository.Task1Repository;
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
public class Task1ServiceImpl implements Task1Service {

    private final Task1Repository task1Repository;
    Task1 taskNumber;

    @Override
    public int findMinValue() {
        return task1Repository.findMinNumber();
    }

    @Override
    public int findMaxValue() {
        return task1Repository.findMaxNumber();
    }

    @Override
    public List<Integer> listAllDistinctNumbers() {
        return task1Repository.findDistinctByNumbers();
    }

    @Override
    public int countDistinctNumbers() {
        return task1Repository.findDistinctByCountNumbers();
    }

    @Override
    public int countNumbers() {
        return (int) task1Repository.count();
    }

    @Override
    public void saveDataFromCsv(MultipartFile file) {
        List<Task1> taskOneNumbers =new ArrayList<>();

        try{
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(','));
            for (CSVRecord record: csvParser){
                taskNumber = new Task1();
                taskNumber.setNumbers(Integer.parseInt(record.get(0)));
               taskOneNumbers.add(taskNumber);
            }
            task1Repository.saveAll(taskOneNumbers);
            csvParser.close();
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
