package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(String name) {
        if(name.equals("")) {
            return clientRepository.findAll();
        }else {
            return clientRepository.findAllByNameContainingIgnoreCase(name);
        }
    }


    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        // Verificaço de regras

        Client client = clientRequestDTO.toClient();

        return new ClientResponseDTO(clientRepository.save(client));
    }
}
