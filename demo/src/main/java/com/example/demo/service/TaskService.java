package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public String addTask(Task task) {
        taskDao.save(task);
        return "task added";
    }

    public String delete(Task task) {
        taskDao.delete(task);
        return "task deleted";
    }

    public String updateStatus(int taskID, StatusUpdateDto status) {
        Optional<Task> optionalTask = taskDao.findById(taskID);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(status.getStatus());
            taskDao.save(task);
            return "Task status updated";
        }

        return "Task not found";
    }

}
