package org.example.school_manager.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;
    private String lastName;
    private String firstName;
    private LocalDate birthDate;
}
