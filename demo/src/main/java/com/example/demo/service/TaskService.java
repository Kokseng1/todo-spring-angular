package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.UserAuthenticationProvider;
import com.example.demo.dao.TaskDao;
import com.example.demo.dto.StatusUpdateDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entities.Task;
import com.example.demo.entities.User;
import com.example.demo.mappers.UserMapper;
import com.example.demo.repositories.UserRepository;

@Service
public class TaskService {
    private final UserMapper userMapper;
    private final TaskDao taskDao;

    @Autowired
    public TaskService(UserMapper userMapper,TaskDao taskDao) {
        this.taskDao = taskDao;
        this.userMapper = userMapper;
    }
    
    public List<Task> getAllTasks() {
        long user_id = UserAuthenticationProvider.getCurrentUserDto().getId();
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return taskDao.findByUserId(user_id, sort);

    }

    public List<Task> getTaskByStatus(boolean status) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return taskDao.findByStatus(status, sort);
    }

    public ResponseEntity<Map<String, String>> addTask(Task task) {
        Map<String, String> response = new HashMap<>();
        UserDto userDto = UserAuthenticationProvider.getCurrentUserDto();
        User user = this.userMapper.toUser(userDto);
        task.setUser(user);
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
