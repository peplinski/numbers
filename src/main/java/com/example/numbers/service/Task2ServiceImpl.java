package com.example.numbers.service;

import com.example.numbers.model.Task2;
import com.example.numbers.repository.Task2Repository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class Task2ServiceImpl implements Task2Service{

    private final Task2Repository task2Repository;
    @Override
    public void readDataFromCsv(MultipartFile file) {
        List<Task2> task2Numbers =new ArrayList<>();

        try{
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(','));
            for (CSVRecord record: csvParser){
                Task2 taskNumber = new Task2();
                taskNumber.setNumbers(Integer.parseInt(record.get(0)));
                task2Numbers.add(taskNumber);
            }
            task2Repository.saveAll(task2Numbers);
            csvParser.close();
            reader.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<String> findSum(int sum){
        List<Integer>numbersList =task2Repository.findNumbers(sum);
        List<String> sorttedLIst = new ArrayList<>();
        for (int i = 0; i < numbersList.size(); i++)
            for (int j = i + 1; j < numbersList.size(); j++)
                if (numbersList.get(j) + numbersList.get(i) == sum)
                    sorttedLIst.add(numbersList.get(j) + " " + numbersList.get(i));
        Collections.sort(sorttedLIst);
        return sorttedLIst;
    }
}
