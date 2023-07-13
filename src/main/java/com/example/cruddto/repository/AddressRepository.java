package com.example.cruddto.repository;

import com.example.cruddto.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address , Integer> {
}
