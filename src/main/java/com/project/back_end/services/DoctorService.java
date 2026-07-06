package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {

    public List<Doctor> getAllDoctors() {
        // Logic to fetch all doctors from a repository goes here
        return new ArrayList<>();
    }

    public Doctor addDoctor(Doctor doctor) {
        // Logic to save to database goes here
        return doctor;
    }
}
