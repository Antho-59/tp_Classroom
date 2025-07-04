package org.example.classroom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.dto.ClassroomResponseDTO;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private long teacherId;
    private long studentId;

    public ClassroomResponseDTO entityToDto(){
        return ClassroomResponseDTO.builder().id(getId()).name(getName()).build();
    }

}
