package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDao;
import com.example.demo.dto.StatusUpdateDto;
import com.example.demo.entities.Task;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public List<Task> getAllTasks() {
        return taskDao.findAll(Sort.by(Sort.Order.asc("id")));
    }

    public List<Task> getTaskByStatus(boolean status) {
        return taskDao.findByStatus(status);
    }

    public ResponseEntity<Map<String, String>> addTask(Task task) {
        Map<String, String> response = new HashMap<>();
        taskDao.save(task);
        response.put("message", "Task added");

        return ResponseEntity.ok(response);
    }

    public  ResponseEntity<Map<String, String>> delete(int id) {
        Map<String, String> response = new HashMap<>();
        Optional<Task> optionalTask = taskDao.findById(id);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            taskDao.delete(task);
           response.put("message", "Task deleted");
            return ResponseEntity.ok(response);
        }else {
            response.put("message", "Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    public ResponseEntity<Map<String, String>> updateStatus(int taskID, StatusUpdateDto status) {
        Map<String, String> response = new HashMap<>();
        Optional<Task> optionalTask = taskDao.findById(taskID);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status.getStatus());
            taskDao.save(task);
            response.put("message", "Task status updated");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Task not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
