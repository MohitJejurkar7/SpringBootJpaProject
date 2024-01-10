package com.example.tech;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeadRepo extends JpaRepository<Lead, Integer> {
    @Override
    Optional<Lead> findById(Integer integer);
    List<Lead> findByMobileNumber(String mobileNumber);
}
