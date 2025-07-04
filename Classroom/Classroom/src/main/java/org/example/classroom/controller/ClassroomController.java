package org.example.classroom.controller;


import org.example.classroom.dto.ClassroomReceiveDTO;
import org.example.classroom.dto.ClassroomResponseDTO;
import org.example.classroom.entity.Classroom;
import org.example.classroom.service.ClassroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private ClassroomService service;

    public ClassroomService classroomService;
    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public ClassroomResponseDTO getClassroom(@PathVariable long id){
        ClassroomResponseDTO classroom = classroomService.getClassroom(id);
        return classroomService.classroomToClassroomResponseDTO(classroom);

    }

    @PostMapping
    public ResponseEntity<ClassroomResponseDTO> createClassroom(@RequestBody ClassroomReceiveDTO classroomReceiveDTO){
        return ResponseEntity.status(201).body(service.createClassroom(classroomReceiveDTO.dtoToEntity()));

    }
}
