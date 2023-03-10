package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.enums.RoleNames;
import com.saper.backend.model.Client;
import com.saper.backend.model.Role;
import com.saper.backend.repository.ClientRepository;
import com.saper.backend.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    public List<Client> findAll(String name) {
        if(name.equals("")) {
            return clientRepository.findAll();
        }else{
            return clientRepository.findAllByNameIgnoreCase(name);
        }
    }

    public ResponseEntity<Object> find(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new NoSuchElementException("client not found"));

        return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(client));
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id).orElseThrow();

        // Modificar
        if(clientRequestDTO.getName()!=null){
            client.setName(clientRequestDTO.getName());
        }
        if(clientRequestDTO.getPassword()!=null){
            client.setPassword(clientRequestDTO.getPassword());
        }
        if(clientRequestDTO.getLogin()!=null){
            client.setLogin(clientRequestDTO.getLogin());
        }

        // Salvar
        ClientResponseDTO clientResponseDTO = new ClientResponseDTO(clientRepository.save(client));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponseDTO);
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
