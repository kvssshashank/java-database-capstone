package com.project.back_end.repo;

import com.project.back_end.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Find patient by email - CRITERION 1
    Optional<Patient> findByEmail(String email);
    
    // Find patient by phone - CRITERION 2
    Optional<Patient> findByPhone(String phone);
    
    // Find patient by email or phone - CRITERION 3
    @Query("SELECT p FROM Patient p WHERE p.email = :email OR p.phone = :phone")
    Optional<Patient> findByEmailOrPhone(@Param("email") String email, 
                                          @Param("phone") String phone);
    
    // Optional: Check if patient exists by email
    boolean existsByEmail(String email);
    
    // Optional: Check if patient exists by phone
    boolean existsByPhone(String phone);
}
