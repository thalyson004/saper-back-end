package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.dto.StudentResponseDTO;
import com.saper.backend.model.Client;
import com.saper.backend.model.Student;
import com.saper.backend.repository.ClientRepository;
import com.saper.backend.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClientRepository clientRepository;


    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();
        clientRepository.save(client);

        Student student = new Student();

        //TODO: Fazer lógica da matatrícula
        student.setRegistration("20224344535");
        student.setPaid(false);
        student.setClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(studentRepository.save(student)));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado.");
        }
    }
}
