package com.example.cruddto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDto {
    private String subjectName;
    private String firstName;
    private String lastName;
    private String category;

}
