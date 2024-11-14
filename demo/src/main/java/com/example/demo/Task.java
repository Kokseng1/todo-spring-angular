package com.example.demo;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean status;

    //need to add getters and setters bc not using lombok
    public Integer getId() {
        return id;
    }

    // Setter for 'id'
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter for 'name'
    public String getName() {
        return name;
    }

    // Setter for 'name'
    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    // Setter for 'name'
    public void setStatus(boolean status) {
        this.status = status;
    }
}
