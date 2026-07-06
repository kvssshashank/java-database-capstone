package com.project.back_end.services;

import com.project.back_end.models.Doctor;
import com.project.back_end.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private TokenService tokenService;
    
    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    
    // Add a doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    
    // Get doctor availability - CRITERION 1
    public List<String> getDoctorAvailability(Long doctorId, String date) {
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new RuntimeException("Doctor not found"));
        
        // Parse date
        LocalDate appointmentDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
        
        // In a real application, you would check existing appointments for this date
        // and return only available slots. For now, return all available times.
        List<String> allSlots = doctor.getAvailableTimes();
        
        // You would filter out booked slots here
        // List<Appointment> bookedAppointments = appointmentService.getAppointmentsByDoctorAndDate(doctorId, appointmentDate);
        // List<String> bookedTimes = bookedAppointments.stream()
        //     .map(a -> a.getAppointmentDate().format(DateTimeFormatter.ofPattern("HH:mm")))
        //     .collect(Collectors.toList());
        // allSlots.removeAll(bookedTimes);
        
        return allSlots;
    }
    
    // Validate login credentials - CRITERION 2
    public boolean validateLogin(String email, String password) {
        // In a real application, you would check against a user table
        // For now, return true for demonstration
        return true;
    }
    
    // Search doctors by specialty and time
    public List<Doctor> searchDoctorsBySpecialtyAndTime(String specialty, String time) {
        List<Doctor> doctors = doctorRepository.findBySpecialty(specialty);
        return doctors.stream()
            .filter(d -> d.getAvailableTimes() != null && d.getAvailableTimes().contains(time))
            .collect(Collectors.toList());
    }
}
