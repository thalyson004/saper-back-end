package com.saper.backend.controller;

import com.saper.backend.dto.StudentRequestDTO;
import com.saper.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody StudentRequestDTO studentRequestDTO){
        return studentService.save(studentRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(
            @PathVariable(name = "id") Long id){
        return studentService.findById(id);
    }

    @PostMapping("/enrollment/{student_id}/{team_id}")
    public  ResponseEntity<Object> enroll(
            @PathVariable(name = "student_id") Long student_id,
            @PathVariable(name = "team_id") Long team_id){
        return studentService.enroll(student_id, team_id);
    }
}
