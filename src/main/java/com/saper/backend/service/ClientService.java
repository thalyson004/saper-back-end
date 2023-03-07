package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import jakarta.transaction.Transactional;
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


    @Transactional
    public ClientResponseDTO save(ClientRequestDTO clientRequestDTO) {
        // Verificaço de regras

        Client client = clientRequestDTO.toClient();

        return new ClientResponseDTO(clientRepository.save(client));
    }

    public ResponseEntity<Object> find(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);

        if(clientOptional.isPresent()){
            System.out.println(clientOptional.get().getStudent().getRegistration());
            return ResponseEntity.status(HttpStatus.OK).body(new ClientResponseDTO(clientOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, ClientRequestDTO clientRequestDTO) {
        //Achar
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            Client client = clientOptional.get();
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
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()){
            Client client = clientOptional.get();
            clientRepository.delete(client);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
        }
    }
}
