package com.example.cruddto.controller;

import com.example.cruddto.dto.UniversityAddressDTO;
import com.example.cruddto.entity.Address;
import com.example.cruddto.entity.University;
import com.example.cruddto.repository.AddressRepository;
import com.example.cruddto.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UniversityController {


    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/university", method = RequestMethod.GET)
    public List<University> getUniversity() {
        return universityRepository.findAll();
    }

    @RequestMapping(value = "/university/{id}", method = RequestMethod.GET)
    public University getUniversityById(@PathVariable Integer id) {
        return universityRepository.findById(id).get();
    }

    @RequestMapping(value = "/university", method = RequestMethod.POST)
    public String addUniversity(@RequestBody UniversityAddressDTO universityAddressDTO) {
        boolean b = universityRepository.existsByName(universityAddressDTO.getName());
        if(!b) {
            University university = new University();
            university.setName(universityAddressDTO.getName());
            Address address = new Address();
            address.setCity(universityAddressDTO.getCity());
            address.setDistrict(universityAddressDTO.getDistrict());
            address.setStreet(universityAddressDTO.getStreet());
            addressRepository.save(address);
            university.setAddress(address);
            universityRepository.save(university);
            return "Successful";
        }
        else {
            return "Bunday nomli universitet mavjud";
        }
    }

    @RequestMapping(value = "/university", method = RequestMethod.PUT)
    public String editUniversity(@RequestBody UniversityAddressDTO universityAddressDTO, @PathVariable Integer id) {

        if(universityRepository.findById(id).isPresent()) {
            University university = universityRepository.findById(id).get();
            Address address = new Address();
            university.setName(universityAddressDTO.getName());
            address.setCity(universityAddressDTO.getCity());
            address.setDistrict(universityAddressDTO.getDistrict());
            address.setStreet(universityAddressDTO.getStreet());
            addressRepository.save(address);
            university.setAddress(address);
            universityRepository.save(university);
            return "Successful";
        }
        return "Error";
    }

    @RequestMapping(value = "/university/{id}", method = RequestMethod.DELETE)
    public String deleteUniversityById(@PathVariable Integer id) {
        universityRepository.deleteById(id);
        return "Deleted";
    }
}
