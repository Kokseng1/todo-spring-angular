package com.example.demo.dto;

public class UserDto {
    private Long id;
    private String first_name;
    private String last_name;
    private String login;
    private String token;

        // Getter for id
        public Long getId() {
            return id;
        }
    
        // Setter for id
        public void setId(Long id) {
            this.id = id;
        }
    
        // Getter for name
        public String getFirstName() {
            return first_name;
        }

         // Setter for name
        public void setFirstName(String first_name) {
            this.first_name = first_name;
        }

        // Setter for name
        public void setLastName(String last_name) {
            this.last_name = last_name;
        }

        public String getLastName() {
            return last_name;
        }
    
        // Getter for login
        public String getLogin() {
            return login;
        }
    
        // Setter for login
        public void setLogin(String login) {
            this.login = login;
        }
    
        // Getter for token
        public String getToken() {
            return token;
        }
    
        // Setter for token
        public void setToken(String token) {
            this.token = token;
        }
}
