package com.saper.backend.service;

import com.saper.backend.dto.UserRequestDTO;
import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.dto.StudentResponseDTO;
import com.saper.backend.model.User;
import com.saper.backend.model.Student;
import com.saper.backend.model.Team;
import com.saper.backend.repository.UserRepository;
import com.saper.backend.repository.StudentRepository;
import com.saper.backend.repository.TeamRepository;
import javax.transaction.Transactional;
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
    UserRepository userRepository;

    @Autowired
    TeamRepository teamRepository;


    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {

        UserRequestDTO userRequestDTO = new UserRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, userRequestDTO);
        User user = userRequestDTO.toClient();
        userRepository.save(user);

        Student student = new Student();

        //TODO: Fazer lógica da matatrícula
        student.setRegistration("20224344535");
        student.setPaid(false);
        student.setClient(user);

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
