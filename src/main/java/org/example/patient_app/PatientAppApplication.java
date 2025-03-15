package org.example.patient_app;

import org.example.patient_app.entities.Patient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PatientAppApplication implements CommandLineRunner {
    public Patient patient;
    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
     patient.save();

    }
}
