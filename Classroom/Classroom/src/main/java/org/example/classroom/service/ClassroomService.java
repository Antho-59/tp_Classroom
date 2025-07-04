package org.example.classroom.service;

import org.example.classroom.dto.ClassroomResponseDTO;
import org.example.classroom.entity.Classroom;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;
import org.example.classroom.util.RestClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClassroomService {

    public RestTemplate restTemplate;

    public ClassroomService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

  public ClassroomResponseDTO createClassroom(Classroom classroomReceiveDTO){
        return new ClassroomResponseDTO();
  }

  public ClassroomResponseDTO getClassroom(Long id){
        return new ClassroomResponseDTO();
  }


  public void deleteClassroom(Long id){
  }

  public ClassroomResponseDTO  classroomToClassroomResponseDTO(ClassroomResponseDTO classroom){
        ClassroomResponseDTO classroomResponseDTO = new ClassroomResponseDTO();
        classroomResponseDTO.setId(classroom.getId());
        classroomResponseDTO.setName(classroom.getName());
      RestClient<Teacher> teacherRestClient = new RestClient<>("http://TEACHER/teacher/"+classroom.getTeacherId(),restTemplate);
      Teacher teacher = teacherRestClient.get(Teacher.class);
      classroomResponseDTO.setTeacher(teacher);
      RestClient<Student> studentRestClient = new RestClient<>("http://STUDENT/student/"+classroom.getStudentId(),restTemplate);
      Student student = studentRestClient.get(Student.class);
      classroomResponseDTO.setStudent(student);

        return classroomResponseDTO;
  }

}
