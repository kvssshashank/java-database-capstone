package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class DoctorService {

    public List<Doctor> getAllDoctors() {
        return Collections.emptyList();
    }

    public Doctor addDoctor(Doctor doctor) {
        return doctor;
    }
    
    public Doctor getDoctorById(Long id) {
        return new Doctor();
    }
}
