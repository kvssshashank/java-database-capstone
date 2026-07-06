package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    
    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        // Logic to fetch appointments from database goes here
        return new ArrayList<>();
    }
    
    public Appointment bookAppointment(Appointment appointment) {
        // Logic to save appointment goes here
        return appointment;
    }
}
