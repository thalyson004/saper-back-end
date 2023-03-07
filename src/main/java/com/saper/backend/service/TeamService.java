package com.saper.backend.service;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.dto.TeamResponseDTO;
import com.saper.backend.model.Box;
import com.saper.backend.model.Team;
import com.saper.backend.repository.BoxRespository;
import com.saper.backend.repository.TeamRepository;
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
}
