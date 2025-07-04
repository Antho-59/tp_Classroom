package org.example.school_manager.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.school_manager.dto.StudentResponseDto;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;

    public StudentResponseDto entityToDto() {
        return StudentResponseDto.builder().id(getId()).lastName(getLastName()).firstName(getFirstName()).birthDate(getBirthDate()).build();
    }
}
