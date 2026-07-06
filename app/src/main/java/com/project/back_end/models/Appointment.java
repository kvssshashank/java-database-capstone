package com.project.back_end.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointment")
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    
    @NotNull(message = "Appointment date is required")
    @Future(message = "Appointment date must be in the future")
    @Column(name = "appointment_date", nullable = false)
    private LocalDateTime appointmentDate;
    
    @Column(nullable = false)
    private String status = "CONFIRMED";
    
    // Constructors
    public Appointment() {}
    
    public Appointment(Doctor doctor, Patient patient, LocalDateTime appointmentDate) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.status = "CONFIRMED";
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }
    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }
    
    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}
