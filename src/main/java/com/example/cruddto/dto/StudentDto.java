package com.example.cruddto.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class StudentDto {
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer group_id;
}
