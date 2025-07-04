package org.example.teacher.controller;

import org.example.teacher.dto.TeacherReceiveDTO;
import org.example.teacher.dto.TeacherResponseDTO;
import org.example.teacher.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(@PathVariable long id){
        return ResponseEntity.ok(service.getTeacherById(id));
    }

    @GetMapping()
    public ResponseEntity<TeacherResponseDTO> getAllTeacher(){
        return ResponseEntity.ok(service.getAllTeacher());
    }

     @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody TeacherReceiveDTO teacherReceiveDTO){
        return ResponseEntity.status(201).body(service.createTeacher(teacherReceiveDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable long id){
        service.deleteTeacherById(id);
    }
}
