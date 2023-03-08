package com.saper.backend.service;

import com.saper.backend.dto.UserRequestDTO;
import com.saper.backend.dto.UserResponseDTO;
import com.saper.backend.model.User;
import com.saper.backend.repository.UserRepository;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(String name) {
        if(name.equals("")) {
            return userRepository.findAll();
        }else{
            return userRepository.findAllByNameIgnoreCase(name);
        }
    }


    @Transactional
    public UserResponseDTO save(UserRequestDTO userRequestDTO) {
        // Verificaço de regras

        User user = userRequestDTO.toClient();

        return new UserResponseDTO(userRepository.save(user));
    }

    public ResponseEntity<Object> find(Long id) {
        Optional<User> clientOptional = userRepository.findById(id);

        if(clientOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new UserResponseDTO(clientOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, UserRequestDTO userRequestDTO) {
        //Achar
        Optional<User> clientOptional = userRepository.findById(id);
        if(clientOptional.isPresent()){
            User user = clientOptional.get();
            // Modificar
            if(userRequestDTO.getName()!=null){
                user.setName(userRequestDTO.getName());
            }
            if(userRequestDTO.getPassword()!=null){
                user.setPassword(userRequestDTO.getPassword());
            }
            if(userRequestDTO.getLogin()!=null){
                user.setLogin(userRequestDTO.getLogin());
            }
            // Salvar
            UserResponseDTO userResponseDTO = new UserResponseDTO(userRepository.save(user));
            return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<User> clientOptional = userRepository.findById(id);
        if(clientOptional.isPresent()){
            User user = clientOptional.get();
            userRepository.delete(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
