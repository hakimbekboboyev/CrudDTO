package com.example.cruddto.dto;

import com.example.cruddto.entity.University;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FacultyDto {
    private String name;
    private Integer university_id;
}
