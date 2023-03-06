package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(String name) {
        if(name.equals("")) {
            return clientRepository.findAll();
        }else{
            return clientRepository.findAllByNameIgnoreCase(name);
        }
    }


    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        // Verificaço de regras

        Client client = clientRequestDTO.toClient();

        return new ClientResponseDTO(clientRepository.save(client));
    }

    public ResponseEntity<Object> find(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(clientOptional.get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }
}
