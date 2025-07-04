package org.example.school_manager.service;

import com.netflix.discovery.provider.Serializer;
import org.example.school_manager.entity.Student;
import org.example.school_manager.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student){
        return studentRepository.save(student);
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public void delete(long id){
        studentRepository.deleteById(id);
    }
}
