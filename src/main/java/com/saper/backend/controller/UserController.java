package com.saper.backend.controller;

import com.saper.backend.dto.UserRequestDTO;
import com.saper.backend.dto.UserResponseDTO;
import com.saper.backend.model.User;
import com.saper.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> find(@PathVariable(name = "id") Long id){
        return userService.find(id);
    }

    @GetMapping
    public List<UserResponseDTO> findAll(
            @RequestParam(name = "name", defaultValue = "") String name){
        List<User> list = userService.findAll(name);
        return list.stream().map(UserResponseDTO::new).toList();
    }

    @PostMapping
    public UserResponseDTO save(@RequestBody UserRequestDTO userRequestDTO){
        return userService.save(userRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody UserRequestDTO userRequestDTO){
        return userService.update(id, userRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id){
        return userService.delete(id);
    }
}
