package com.api_sanchez.api_todo_app.repository;

import com.api_sanchez.api_todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
