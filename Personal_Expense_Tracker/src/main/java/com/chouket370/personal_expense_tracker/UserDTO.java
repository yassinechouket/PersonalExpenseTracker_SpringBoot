package com.chouket370.personal_expense_tracker;

import com.chouket370.personal_expense_tracker.User;

public class UserDTO {
    private Integer id;
    private String name;
    private String email;


    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();

    }

    // Getters et Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return name; }
    public void setUsername(String username) { this.name = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


}