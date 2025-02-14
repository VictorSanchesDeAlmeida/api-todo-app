package com.api_sanchez.api_todo_app.service;



import com.api_sanchez.api_todo_app.dto.UserDTO;
import com.api_sanchez.api_todo_app.model.User;
import com.api_sanchez.api_todo_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoService todoService;

    public List<UserDTO> getAllUsers(){

        Sort sortBy =  Sort.by(new Sort.Order(Sort.Direction.ASC, "id").ignoreCase());

        return userRepository.findAll(sortBy)
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }

    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        user.setId(id);
        return userRepository.saveAndFlush(user);
    }

    public void DeleteUser(Long id) {
        todoService.deleteAllTodoByUserId(id);
        userRepository.deleteById(id);
    }
}
