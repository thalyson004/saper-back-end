package com.saper.backend.controller;

import com.saper.backend.dto.TeamResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.model.Student;
import com.saper.backend.model.Team;
import com.saper.backend.repository.StudentRepository;
import com.saper.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    ClientService clientService;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/client")
    public ResponseEntity<Object> findClient(){
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if(principal instanceof Client client) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(clientService.find(client.getId()).getBody());
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/enrollments")
    public ResponseEntity<Object> findEnrollments(){
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if(principal instanceof Client client) {
            Long client_id = client.getId();

            Optional<Student> studentOptional = studentRepository.findByClientId(client_id);
            List<TeamResponseDTO> teams = studentOptional.get()
                                        .getTeams().stream()
                                        .map(TeamResponseDTO::new).toList();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(teams);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
