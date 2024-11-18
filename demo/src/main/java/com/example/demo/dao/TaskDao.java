package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Task;

@Repository 
public interface TaskDao extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(boolean status);
}
