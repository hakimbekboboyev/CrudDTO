package com.example.cruddto.controller;

import com.example.cruddto.entity.Student;
import com.example.cruddto.repository.GroupRepository;
import com.example.cruddto.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {
    final StudentRepository studentRepository;
    final GroupRepository groupRepository;

    public StudentController(StudentRepository studentRepository, GroupRepository groupRepository) {
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
    }

    @GetMapping("/student")
    public ResponseEntity getAllStudent(){
        List<Student> allStudent = studentRepository.findAll();
        if(allStudent.isEmpty()){
            return ResponseEntity.badRequest().body("Student Not Found");
        }
        else {
            return ResponseEntity.ok(allStudent);
        }
    }

}

