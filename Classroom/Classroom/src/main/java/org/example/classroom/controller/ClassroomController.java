package org.example.classroom.controller;


import org.example.classroom.dto.ClassroomResponseDTO;
import org.example.classroom.entity.Classroom;
import org.example.classroom.service.ClassroomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    public ClassroomService classroomService;
    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }

    @GetMapping("/{id}")
    public ClassroomResponseDTO getClassroom(@PathVariable long id){
        ClassroomResponseDTO classroom = classroomService.getClassroom(id);
        return classroomService.classroomToClassroomResponseDTO(classroom);

    }

    @PostMapping("/create")
    public ClassroomResponseDTO createClassroom(@RequestBody Classroom classroom){
        return classroomService.createClassroom(classroom);
    }
}
