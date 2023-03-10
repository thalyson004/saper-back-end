package com.saper.backend.service;

import com.saper.backend.dto.ClientRequestDTO;
import com.saper.backend.dto.ClientResponseDTO;
import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.dto.StudentResponseDTO;
import com.saper.backend.enums.RoleNames;
import com.saper.backend.exception.ErrorDTO;
import com.saper.backend.exception.exceptions.StudentStoreException;
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

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
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


    @Transactional
    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        Client client = clientRequestDTO.toClient();

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

        try {
            student = studentRepository.save(student);
        }catch (Exception e){
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setTimeStamp(Instant.now());
            errorDTO.setPath("/aqui");
            errorDTO.setError("Não foi possível criar o estudante");
            errorDTO.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(errorDTO);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(student));
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

        Optional<Student> studentOptional = studentRepository.findById(student_id);

        if(studentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado.");
        }

        Optional<Team> teamOptional = teamRepository.findById(team_id);

        if(teamOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado.");
        }

        Student student = studentOptional.get();
        Team team = teamOptional.get();
        student.getTeams().add(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(studentRepository.save(student)));
    }
}
