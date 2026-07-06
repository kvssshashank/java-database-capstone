package com.project.back_end.controllers;

import com.project.back_end.models.Prescription;
import com.project.back_end.services.PrescriptionService;
import com.project.back_end.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    
    @Autowired
    private PrescriptionService prescriptionService;
    
    @Autowired
    private TokenService tokenService;
    
    // Issue prescription - WITH TOKEN AND VALIDATION
    @PostMapping("/issue/{token}")
    public ResponseEntity<Map<String, String>> issuePrescription(
            @PathVariable String token,
            @Valid @RequestBody Prescription prescription) {
        
        // Validate token
        if (!tokenService.validateToken(token)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid or expired token");
            return ResponseEntity.status(401).body(errorResponse);
        }
        
        Prescription savedPrescription = prescriptionService.issuePrescription(prescription);
        
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Prescription issued successfully");
        response.put("prescriptionId", savedPrescription.getId().toString());
        
        return ResponseEntity.ok(response);
    }
    
    // Get prescriptions by patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<?> getPrescriptionsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptionsByPatient(patientId));
    }
}
