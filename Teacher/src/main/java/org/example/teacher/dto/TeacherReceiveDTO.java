package org.example.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.teacher.entity.Teacher;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherReceiveDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Teacher dtoToEntity() {
        return Teacher.builder().firstName(getFirstName()).lastName(getLastName()).birthDate(getBirthDate()).build();
    }


}
