package org.example.classroom.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.entity.Student;
import org.example.classroom.entity.Teacher;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClassroomResponseDTO {

    private Long id;
    private String name;
    private Teacher teacher;
    private Student student;

    public Long getStudentId() {
        return student.getId();
    }

    public Long getTeacherId() {
        return teacher.getId();
    }
}
