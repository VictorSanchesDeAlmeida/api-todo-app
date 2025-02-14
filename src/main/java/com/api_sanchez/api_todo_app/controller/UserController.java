package com.api_sanchez.api_todo_app.controller;


import com.api_sanchez.api_todo_app.dto.TodoDTO;
import com.api_sanchez.api_todo_app.dto.UserDTO;
import com.api_sanchez.api_todo_app.model.Todo;
import com.api_sanchez.api_todo_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api_sanchez.api_todo_app.service.UserService;
import com.api_sanchez.api_todo_app.service.TodoService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDTO createUser(@RequestBody User user){
        user = userService.saveUser(user);
        return userService.toDTO(user);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@RequestBody User user, @PathVariable Long id){
        user = userService.updateUser(user, id);
        return userService.toDTO(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        try{
            userService.DeleteUser(id);
            return ResponseEntity.ok("User deleted.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, user not deleted");
        }
    }

    @GetMapping("/{id}/todo")
    public List<TodoDTO> getTodosByUser(@PathVariable Long id){
        return todoService.getTasksByUserId(id);
    }

    @GetMapping("/{id}/todo/{idTodo}")
    public Optional<TodoDTO> getTodo(@PathVariable Long id, @PathVariable Long idTodo){
        return todoService.getTodo(idTodo);
    }

    @PostMapping("/{id}/todo")
    public TodoDTO createTodo(@RequestBody TodoDTO todoDTO, @PathVariable Long id){
        Todo todo = todoService.saveTodo(todoDTO, id);
        return todoService.toDTO(todo);
    }

    @PutMapping("/{id}/todo/{idTodo}")
    public TodoDTO updateTodo(@RequestBody Todo todo, @PathVariable Long id, @PathVariable Long idTodo){
        Todo todoUpdated = todoService.updateTodo(todo, id , idTodo);
        return todoService.toDTO(todoUpdated);
    }

    @DeleteMapping("/{id}/todo/{idTodo}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id, @PathVariable Long idTodo){
        try{
            todoService.deleteTodo(idTodo);
            return ResponseEntity.ok().body("Todo deleted.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Todo not deleted.");
        }
    }

}
