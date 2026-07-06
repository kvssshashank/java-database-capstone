package com.project.back_end.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Assuming a Patient model exists similar to Doctor
// import com.project.back_end.models.Patient; 

@Repository
public interface PatientRepository extends JpaRepository<Object, Long> {
    // Custom database queries for Patients can be defined here
}
