package com.example.cruddto.controller;

import com.example.cruddto.dto.FacultyDto;
import com.example.cruddto.entity.Faculty;
import com.example.cruddto.entity.University;
import com.example.cruddto.repository.FacultyRepository;
import com.example.cruddto.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FacultyController {

    @Autowired
    FacultyRepository facultyRepository;

    @Autowired
    UniversityRepository universityRepository;

    @RequestMapping(value = "/faculty", method = RequestMethod.POST)
    public String addFaculty(@RequestBody FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversity_id());
        if (optionalUniversity.isPresent()) {
            faculty.setUniversity(optionalUniversity.get());
            facultyRepository.save(faculty);
            return "Faculty added";
        } else {
            return "University Not Found";
        }
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.GET)
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @RequestMapping(value = "/faculty/{university_id}", method = RequestMethod.GET)
    public List<Faculty> getFaculty(@PathVariable Integer university_id) {
        List<Faculty> allByUniversityId = facultyRepository.findAllByUniversityId(university_id);
        return allByUniversityId;
    }

}
