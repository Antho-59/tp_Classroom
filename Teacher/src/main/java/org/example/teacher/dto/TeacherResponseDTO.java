package org.example.teacher.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TeacherResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
