package com.project.back_end.services;

import com.project.back_end.models.Appointment;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
public class AppointmentService {

    public List<Appointment> getAllAppointments() {
        return Collections.emptyList();
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return Collections.emptyList();
    }

    public Appointment bookAppointment(Appointment appointment) {
        appointment.setStatus("CONFIRMED");
        return appointment;
    }
}
