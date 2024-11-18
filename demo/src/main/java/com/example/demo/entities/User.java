package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String setLastName(String name) {
        return this.lastName = name;
    }

    public String getLogin() {
        return this.login;
    }

    public String setLogin(String login) {
        return this.login = login;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String setFirstName(String name) {
        return this.firstName = name;
    }
}
