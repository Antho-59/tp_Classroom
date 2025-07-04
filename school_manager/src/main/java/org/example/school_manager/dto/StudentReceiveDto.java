package org.example.school_manager.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.school_manager.entity.Student;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentReceiveDto {

    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    public Student dtoToEntity() {
        return Student.builder().firstName(getFirstName()).lastName(getLastName()).birthDate(getBirthDate()).build();
    }
}
