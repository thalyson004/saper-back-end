package com.saper.backend.service;

import com.saper.backend.dto.*;
import com.saper.backend.enums.RoleNames;
import com.saper.backend.exception.exceptions.ConflictStoreException;
import com.saper.backend.model.Client;
import com.saper.backend.model.Role;
import com.saper.backend.model.Student;
import com.saper.backend.model.Team;
import com.saper.backend.repository.ClientRepository;
import com.saper.backend.repository.RoleRepository;
import com.saper.backend.repository.StudentRepository;
import com.saper.backend.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
          studentRepository.findAll().stream().map((student)->new StudentResponseDTO(student)).toList()
        );
    }


    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }

        Optional<Role> role = roleRepository.findByRole(RoleNames.ROLE_USER);
        List<Role> roles = new ArrayList<>();
        roles.add(role.get());
        client.setRoles(roles);

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

    @Transactional
    public ResponseEntity<Object> enroll(Long student_id, Long team_id) {

        Student student = studentRepository.findById(student_id).orElseThrow(() -> new NoSuchElementException("student not found"));

        Team team = teamRepository.findById(team_id).orElseThrow(() -> new NoSuchElementException("team not found"));

        if(student.getTeams().contains(team)){
            throw new ConflictStoreException("student already enrolled");
        }

        //TODO: Verificar capacidade

        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(studentRepository.save(student)));
    }


    public ResponseEntity<Object> update(Long id, StudentUpdateDTO studentUpdateDTO) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("student not found"));

        student.setPaid(studentUpdateDTO.isPaid());

        return ResponseEntity.status(HttpStatus.OK).body(
                new StudentResponseDTO(studentRepository.save(student))
        );
    }
}
