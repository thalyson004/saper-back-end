package com.saper.backend.controller;

import com.saper.backend.dto.TeamRequestDTO;
import com.saper.backend.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody TeamRequestDTO teamRequestDTO){
        return teamService.save(teamRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return teamService.findById(id);
    }

}
