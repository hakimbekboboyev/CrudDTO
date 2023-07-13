package com.example.cruddto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDto {
    private String name;
    private TeacherDto teacher;
}
