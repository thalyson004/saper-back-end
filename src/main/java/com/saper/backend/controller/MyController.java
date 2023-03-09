package com.saper.backend.controller;

import com.saper.backend.model.Client;
import com.saper.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    ClientService clientService;

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

}
