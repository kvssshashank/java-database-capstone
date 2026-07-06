package com.project.back_end.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping
    public ResponseEntity<String> issuePrescription(@RequestBody Object prescriptionData) {
        return ResponseEntity.ok("Prescription successfully issued.");
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Object> getPrescriptions(@PathVariable Long patientId) {
        return ResponseEntity.ok().build();
    }
}
