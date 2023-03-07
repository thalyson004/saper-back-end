package com.saper.backend.service;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.model.Box;
import com.saper.backend.model.Team;
import com.saper.backend.repository.BoxRespository;
import com.saper.backend.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    BoxRespository boxRespository;

    @Transactional
    public ResponseEntity<Object> save(TeamRequestDTO teamRequestDTO) {
        Long box_id = teamRequestDTO.getBox_id();

        Optional<Box> boxOptional = boxRespository.findById(box_id);

        if(boxOptional.isPresent()){
            Team team = new Team();
            team.setSchedule(teamRequestDTO.getSchedule());
            team.setBox(boxOptional.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(teamRepository.save(team));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado.");
        }
    }
}
