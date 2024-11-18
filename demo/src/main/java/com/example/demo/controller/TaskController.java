package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StatusUpdateDto;
import com.example.demo.entities.Task;
import com.example.demo.service.TaskService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("task")
public class TaskController {
    @Autowired
    TaskService taskService;
    
    @GetMapping("allTasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("status/{status}")
    public List<Task> getTaskByStatus(@PathVariable boolean status) {
        return taskService.getTaskByStatus(status);
    }

    @PostMapping("add")
    public ResponseEntity<Map<String, String>> addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteTask(@PathVariable int id) {
        return taskService.delete(id);
    }

    @PutMapping("{taskID}")
    public ResponseEntity<Map<String, String>> editTaskStatus(@PathVariable int taskID, @RequestBody StatusUpdateDto status) {
        return taskService.updateStatus(taskID, status);
    }
}
