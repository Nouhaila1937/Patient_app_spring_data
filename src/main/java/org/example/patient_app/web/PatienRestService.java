package org.example.patient_app.web;

import org.example.patient_app.entities.Patient;
import org.example.patient_app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatienRestService {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients(){
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient findPatients(@PathVariable Long id){
        return patientRepository.findById(id).get();
    }

}
