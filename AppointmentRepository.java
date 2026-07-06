package com.project.back_end.repo;

import com.project.back_end.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    
    List<Appointment> findByPatientId(Long patientId);
    
    List<Appointment> findByDoctorIdAndAppointmentDateBetween(
        Long doctorId, LocalDateTime startDate, LocalDateTime endDate);
    
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND DATE(a.appointmentDate) = DATE(:date)")
    List<Appointment> findByDoctorIdAndDate(@Param("doctorId") Long doctorId, 
                                             @Param("date") LocalDateTime date);
}
