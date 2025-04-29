package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String homeRedirect() {
        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "list_tasks";
    }

    @GetMapping("/tasks/create")
    public String createTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "create_task";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "edit_task";
    }

    @PostMapping("/tasks/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.createTask(task); // same as save since ID is present
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
