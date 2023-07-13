package com.example.cruddto.controller;

import com.example.cruddto.dto.StudentDto;
import com.example.cruddto.entity.Group;
import com.example.cruddto.entity.Student;
import com.example.cruddto.repository.GroupRepository;
import com.example.cruddto.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/student")
    public ResponseEntity addStudent(@RequestBody StudentDto studentDto){
        Optional<Group> groupById = groupRepository.findById(studentDto.getGroup_id());
        if(groupById.isPresent()){
            Student student = new Student();
            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            student.setAge(studentDto.getAge());
            student.setGroup(groupById.get());
            studentRepository.save(student);
            return ResponseEntity.ok("Successful");
        }else {
            return ResponseEntity.badRequest().body("Group Not Found!");
        }
    }


    @PutMapping("/student/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,
                                        @RequestBody StudentDto studentDto){
        Optional<Group> groupById = groupRepository.findById(studentDto.getGroup_id());
        Optional<Student> studentById = studentRepository.findById(id);
        if(groupById.isPresent()) {
            if (studentById.isPresent()) {
                Student student = studentById.get();
                student.setFirstName(studentDto.getFirstName());
                student.setLastName(studentDto.getLastName());
                student.setAge(studentDto.getAge());
                student.setGroup(groupById.get());
                studentRepository.save(student);
                return ResponseEntity.ok("Successful");
            }else {
                return ResponseEntity.badRequest().body("Student Not Found!");
            }
        }else {
            return ResponseEntity.badRequest().body("Group Not Found!");
        }
    }

}

