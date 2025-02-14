package com.api_sanchez.api_todo_app.model;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String description;

    @Column(nullable = false)
    private boolean completed;

    public Long getId(){
        return id;
    }

    public User getUser(){
        return user;
    }

    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }

    public Boolean getCompleted(){
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long idTodo) {
        this.id = idTodo;
    }
}
