package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @GetMapping("allTasks")
    public List<Task> getAllTasks(){
        // System.out.println("in contrller");
        return taskService.getAllTasks();
    }

    @GetMapping("status/{status}")
    public List<Task> getTaskByStatus(@PathVariable boolean status) {
        return taskService.getTaskByStatus(status);
    }

    @PostMapping("add")
    public String addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("delete")
    public String delteTask(@RequestBody Task task) {
        return taskService.delete(task);
    }
}
