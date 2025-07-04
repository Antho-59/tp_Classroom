package org.example.teacher.service;

import org.example.teacher.dto.TeacherReceiveDTO;
import org.example.teacher.dto.TeacherResponseDTO;
import org.example.teacher.entity.Teacher;
import org.example.teacher.exception.NotFoundException;
import org.example.teacher.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }

    // Crud

    public TeacherResponseDTO createTeacher(TeacherReceiveDTO teacherReceiveDTO){
        return repository.save(teacherReceiveDTO.dtoToEntity()).entityToDto();
    }

    public TeacherResponseDTO getTeacherById(Long id){
        return repository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public TeacherResponseDTO getAllTeacher(){
        return repository.findAll().stream().map(Teacher::entityToDto).findFirst().orElseThrow(NotFoundException::new);
    }

    public void deleteTeacherById(Long id){
        repository.deleteById(id);
        if(repository.findById(id).isPresent()){
            throw new NotFoundException();
        }
        else{
            System.out.println("Professeur supprimé");
        }
    }
}
