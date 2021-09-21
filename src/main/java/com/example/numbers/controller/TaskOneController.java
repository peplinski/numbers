package com.example.numbers.controller;

import com.example.numbers.model.TaskOneNumbers;
import com.example.numbers.service.TaskOneService;
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
public class TaskOneController {
    private final TaskOneService taskOneService;

    @GetMapping("/task1")
    public String task1(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "task1";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,TaskOneNumbers taskOneNumbers, RedirectAttributes attributes) {
        // check if file is empty
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        // normalize the file path
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        taskOneService.saveDataFromCsv(taskOneNumbers.getFile());

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded " + fileName + '!');

        return "redirect:/task1";
    }


    @GetMapping("/showTask1")
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
}
