package com.api_sanchez.api_todo_app.service;

import com.api_sanchez.api_todo_app.dto.TodoDTO;
import com.api_sanchez.api_todo_app.dto.UserDTO;
import com.api_sanchez.api_todo_app.model.Todo;
import com.api_sanchez.api_todo_app.model.User;
import com.api_sanchez.api_todo_app.repository.TodoRepository;
import com.api_sanchez.api_todo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;


    public List<TodoDTO> getTasksByUserId(Long userId){

        User user = new User();
        user.setId(userId);

        return todoRepository.findByUser(user)
                .stream()
                .map(TodoDTO::new)
                .sorted(Comparator.comparing(TodoDTO::getId))
                .collect(Collectors.toList());
    }

    public Todo saveTodo(TodoDTO todoDTO, Long user_id) {

        UserDTO userDTO = userRepository.findById(user_id)
                .map(UserDTO::new)
                .orElseThrow(() -> new RuntimeException("User not find."));

        Todo todo = new Todo();
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setUser(new User(userDTO.getId(), userDTO.getName()));

        todoDTO.setUserId(userDTO.getId());

        return todoRepository.save(todo);

    }

    public TodoDTO toDTO(Todo todo) {
        return new TodoDTO(todo);
    }

    public void deleteAllTodoByUserId(Long id) {
        todoRepository.deleteAllByUserId(id);
    }

    public Todo updateTodo(Todo todo, Long idUser, Long idTodo) {
        todo.setId(idTodo);
        User user = new User();
        user.setId(idUser);
        todo.setUser(user);
        return todoRepository.saveAndFlush(todo);
    }

    public Optional<TodoDTO> getTodo(Long idTodo) {
        return todoRepository.findById(idTodo)
                .map(TodoDTO::new);
    }

    public void deleteTodo(Long idTodo) {
        todoRepository.deleteById(idTodo);
    }
}