package com.project.back_end.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Object, Long> {
    // Standard CRUD operations are automatically provided by JpaRepository
}
