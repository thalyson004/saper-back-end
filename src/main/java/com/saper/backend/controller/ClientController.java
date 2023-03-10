package com.saper.backend.controller;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import com.saper.backend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> find(@PathVariable(name = "id") Long id){
        return clientService.find(id);
    }

    @GetMapping
    public List<ClientResponseDTO> findAll(
            @RequestParam(name = "name", defaultValue = "") String name){
        List<Client> list = clientService.findAll(name);
        return list.stream().map(ClientResponseDTO::new).toList();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.update(id, clientRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id){
        return clientService.delete(id);
    }
}
