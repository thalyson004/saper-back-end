package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
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

    public ResponseEntity<Object> findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if(client.isPresent()) {
            return ResponseEntity.ok(new ClientResponseDTO(client.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    public ResponseEntity<Object> update(Long id, ClientRequestDTO clientRequestDTO) {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()) {
            Client client1 = client.get();

            if(clientRequestDTO.getName()!=null){
                client1.setName(clientRequestDTO.getName());
            }

            if(clientRequestDTO.getLogin()!=null){
                client1.setLogin(clientRequestDTO.getLogin());
            }

            if(clientRequestDTO.getPassword()!=null){
                client1.setPassword(clientRequestDTO.getPassword());
            }

            return ResponseEntity.ok(new ClientResponseDTO(clientRepository.save(client1)));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
