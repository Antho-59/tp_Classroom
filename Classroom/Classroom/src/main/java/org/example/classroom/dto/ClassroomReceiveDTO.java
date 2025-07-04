package org.example.classroom.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.classroom.entity.Classroom;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassroomReceiveDTO {
    private String name;

    public Classroom dtoToEntity(){
        return Classroom.builder().name(getName()).build();
    }
}
