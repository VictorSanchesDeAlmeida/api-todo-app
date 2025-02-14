package com.api_sanchez.api_todo_app.repository;


import com.api_sanchez.api_todo_app.model.Todo;
import com.api_sanchez.api_todo_app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUser(User user);

    @Transactional
    void deleteAllByUserId(long userId);
}
