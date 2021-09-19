package com.example.numbers.controller;

import com.example.numbers.service.TaskOneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class TaskOneController {
    private final TaskOneService taskOneService;

    @GetMapping("/task1")
    public String task1(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "task1";
    }


    @GetMapping("/listDistNumbers")
    public String getNumbers(Model model){
        List<Integer> numbersList = taskOneService.listAllDistinctNumbers();
        model.addAttribute("numbersList", numbersList);

        int numberCount = taskOneService.countNumbers();
        model.addAttribute("numberCount",numberCount);

        int numberDistCount = taskOneService.countDistinctNumbers();
        model.addAttribute("numberDistCount",numberDistCount);

        int minNumber = taskOneService.findMinValue();
        model.addAttribute("minNumber",minNumber);

        int maxNumber = taskOneService.findMaxValue();
        model.addAttribute("maxNumber",maxNumber);
        return "task1";
    }

//    @GetMapping("/count")
//    public String countNumbers(Model model){
//
//        return "task1";
//    }
}
