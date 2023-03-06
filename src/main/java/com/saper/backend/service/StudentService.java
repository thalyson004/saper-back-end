package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.model.Client;
import com.saper.backend.model.Student;
import com.saper.backend.repository.ClientRepository;
import com.saper.backend.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO){
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        Client client = clientRepository.save(clientRequestDTO.toClient());

        Student student = new Student();
        student.setPaid(false);
        //TODO: Inserir lógica da matrícula
        student.setRegistration("202212221");
        student.setClient(client);


        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(student));
    }
}
