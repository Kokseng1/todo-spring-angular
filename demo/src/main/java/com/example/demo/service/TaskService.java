package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Task;
import com.example.demo.dao.TaskDao;

@Service
public class TaskService {
    @Autowired
    TaskDao taskDao;
    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }

    public List<Task> getTaskByStatus(boolean status) {
        return taskDao.findByStatus(status);
    }

    public String addTask(Task task) {
        taskDao.save(task);
        return "task added";
    }

    public String delete(Task task) {
        taskDao.delete(task);
        return "task deleted";
    }

}
