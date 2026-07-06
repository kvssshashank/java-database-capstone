package com.project.back_end.controllers;

import com.project.back_end.models.Doctor;
import com.project.back_end.services.DoctorService;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private TokenService tokenService;
    
    // Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }
    
    // Add a new doctor
    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.addDoctor(doctor));
    }
    
    // Get doctor availability - NEW ENDPOINT
    @GetMapping("/{doctorId}/availability/{date}")
    public ResponseEntity<Map<String, Object>> getDoctorAvailability(
            @PathVariable Long doctorId,
            @PathVariable String date,
            @RequestHeader("Authorization") String token) {
        
        // Validate token
        if (!tokenService.validateToken(token.replace("Bearer ", ""))) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid or expired token");
            return ResponseEntity.status(401).body(errorResponse);
        }
        
        List<String> availableSlots = doctorService.getDoctorAvailability(doctorId, date);
        
        Map<String, Object> response = new HashMap<>();
        response.put("doctorId", doctorId);
        response.put("date", date);
        response.put("availableSlots", availableSlots);
        
        return ResponseEntity.ok(response);
    }
    
    // Search doctors by specialty and time
    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> searchDoctors(
            @RequestParam String specialty,
            @RequestParam String time) {
        return ResponseEntity.ok(doctorService.searchDoctorsBySpecialtyAndTime(specialty, time));
    }
}
