package com.saper.backend.controller;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ClientResponseDTO save(@RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.save(clientRequestDTO);
    }

    @GetMapping
    public List<ClientResponseDTO> findAll(
            @RequestParam(name = "name", defaultValue = "") String name){
        List<Client> list = clientService.findAll(name);
        return list.stream().map(ClientResponseDTO::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object>  find(
            @PathVariable(name = "id") Long id){

        return clientService.findById(id);
    }


}
