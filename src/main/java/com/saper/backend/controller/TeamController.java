package com.saper.backend.controller;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TeamRequestDTO teamRequestDTO){
        return teamService.save(teamRequestDTO);
    }

}
