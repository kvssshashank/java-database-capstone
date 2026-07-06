package com.project.back_end.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @PostMapping("/create")
    public String createPrescription(@RequestBody String prescriptionDetails) {
        return "Prescription saved successfully";
    }
}
