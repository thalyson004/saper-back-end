package com.saper.backend.config.security;

import com.saper.backend.model.Client;
import com.saper.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticatorService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findByLogin(username);
        if(clientOptional.isPresent()){
            return clientOptional.get();
        }else{
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

    }
}
