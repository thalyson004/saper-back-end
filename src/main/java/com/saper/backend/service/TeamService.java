package com.saper.backend.service;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.dto.TeamResponseDTO;
import com.saper.backend.dto.TeamUpdateDTO;
import com.saper.backend.exception.exceptions.FieldException;
import com.saper.backend.model.Box;
import com.saper.backend.model.Team;
import com.saper.backend.repository.BoxRespository;
import com.saper.backend.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    BoxRespository boxRespository;

    public ResponseEntity<Object> save(TeamRequestDTO teamRequestDTO) {
        Long box_id = teamRequestDTO.getBox_id();

        Optional<Box> boxOptional = boxRespository.findById(box_id);

        if(boxOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }

        Box box = boxOptional.get();

        Team team = new Team();
        team.setBox(box);
        team.setSchedule(teamRequestDTO.getSchedule());
        return ResponseEntity.status(HttpStatus.CREATED).body( new TeamResponseDTO(teamRepository.save(team)));
    }

    public ResponseEntity<Object> findById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()-> new NoSuchElementException("team not found"));
        return ResponseEntity.status(HttpStatus.OK).body(new TeamResponseDTO(team));
    }

    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                teamRepository.findAll().stream().map((team)->new TeamResponseDTO(team)).toList()
        );
    }


    public ResponseEntity<Object> update(Long id, TeamUpdateDTO teamUpdateDTO) {
        Team team = teamRepository.findById(id).orElseThrow(
                ()->new NoSuchElementException("team not found")
        );

        //TODO: Verificar se respeita as regras
        String schedule = teamUpdateDTO.getSchedule();

        List<String> parts = Arrays.stream(schedule.split("_")).toList();
        if(parts.size()!=2){
            throw new FieldException("schedule must have one underscore");
        }

        team.setSchedule(schedule);

        return ResponseEntity.status(HttpStatus.OK).body(
                new TeamResponseDTO(teamRepository.save(team)));
    }
}
