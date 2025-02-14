package com.api_sanchez.api_todo_app.dto;

import com.api_sanchez.api_todo_app.model.Todo;
import lombok.Getter;

@Getter
public class TodoDTO {

    private Long id;
    private Long userId;
    private String title;
    private String description;
    private boolean completed;

    public TodoDTO(){}

    public TodoDTO(Todo todo){
        id = todo.getId();
        userId = todo.getUser().getId();
        title = todo.getTitle();
        description = todo.getDescription();
        completed = todo.getCompleted();
    }

    public TodoDTO(String title, String description, Boolean completed){
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public void setUserId(Long user_id){
        this.userId = user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }
}
