package com.session10.controller;

import com.session10.model.TaskItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/task")
public class TaskController {
    private List<TaskItem> tasks = new ArrayList<>();
    public TaskController(){
        tasks.add(new TaskItem("1", "Task 1", LocalDate.of(2023, 10, 1), "HIGH"));
        tasks.add(new TaskItem("2", "Task 2", LocalDate.of(2023, 10, 2), "MEDIUM"));
        tasks.add(new TaskItem("3", "Task 3", LocalDate.of(2023, 10, 3), "LOW"));
    }
    @GetMapping
    public String showTask(Model model) {
        model.addAttribute("tasks", tasks);
        return "task-list";
    }
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        return "task-form";
    }
    @PostMapping("/save")
    public String saveTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "task-form";
        }
        taskItem.setId(UUID.randomUUID().toString());
        tasks.add(taskItem);
        return "redirect:/task";
    }
}
