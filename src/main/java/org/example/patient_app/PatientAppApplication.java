package org.example.patient_app;

import org.example.patient_app.entities.*;
import org.example.patient_app.repository.MedecinRepository;
import org.example.patient_app.repository.PatientRepository;
import org.example.patient_app.repository.RendezVousRepository;
import org.example.patient_app.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientAppApplication {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(PatientAppApplication.class, args);
    }
    @Bean
        //s'exécute au démarrage
    CommandLineRunner start(IHospitalService hospitalService, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository){
        return args -> {
            Stream.of("Mohammed", "Hassan", "Najat").forEach(name->{
                Patient patient = new Patient();
                patient.setName(name);
                patient.setMalade(false);
                patient.setDateOfBirth(new Date());
                hospitalService.savePatient(patient);
            });

            Stream.of("Aymane", "Hanane", "Yassmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setName(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                hospitalService.saveMedecin(medecin);
            });

            Patient patient = patientRepository.findByName("Mohammed");

            Medecin medecin = medecinRepository.findByNom("Yassmine");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);

            hospitalService.saveRDV(rendezVous);

            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

            Consultation consultation = new Consultation();
            consultation.setDateconsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport 1");


            hospitalService.saveConsultation(consultation);

        };
    }


}
