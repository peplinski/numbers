package com.example.numbers.controller;

import com.example.numbers.model.Task1;
import com.example.numbers.service.Task1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class Task1Controller {
    private final Task1Service task1Service;

    @GetMapping("/task1")
    public String task1() {

        return "task1";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file, Task1 task1, RedirectAttributes attributes) {
        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        task1Service.saveDataFromCsv(task1.getFile());

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/task1";
    }


    @GetMapping("/showTask1")
    public String getNumbers(Model model){
        List<Integer> numbersList = task1Service.listAllDistinctNumbers();
        model.addAttribute("numbersList", numbersList);

        int numberCount = task1Service.countNumbers();
        model.addAttribute("numberCount",numberCount);

        int numberDistCount = task1Service.countDistinctNumbers();
        model.addAttribute("numberDistCount",numberDistCount);

        int minNumber = task1Service.findMinValue();
        model.addAttribute("minNumber",minNumber);

        int maxNumber = task1Service.findMaxValue();
        model.addAttribute("maxNumber",maxNumber);
        return "task1";
    }
}
