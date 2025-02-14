package com.api_sanchez.api_todo_app.dto;


import com.api_sanchez.api_todo_app.model.User;

public class UserDTO {

    private Long id;
    private String name;

    public  UserDTO(){}

    public UserDTO(User user) {
        name = user.getName();
        id = user.getId();
    }

    public void setName(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }
}