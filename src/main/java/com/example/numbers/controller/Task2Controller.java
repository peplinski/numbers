package com.example.numbers.controller;

import com.example.numbers.model.Task2;
import com.example.numbers.service.Task2Service;
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
public class Task2Controller {

    private final Task2Service task2Service;

    @GetMapping("/task2")
    public String task1() {

        return "task2";
    }

    @PostMapping("/uploadNumbers")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file, Task2 task2, RedirectAttributes attributes) {
        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        task2Service.readDataFromCsv(task2.getFile());

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/task2";
    }

    @GetMapping("/showSum")
    public String showPairOfNumbers(@RequestParam(value = "sum") int sum, Model model) {
        model.addAttribute("sum", sum);
        List<String> sorttedLIst = task2Service.findSum(sum);
        model.addAttribute("sorttedLIst", sorttedLIst);

        return "/task2";
    }
}
