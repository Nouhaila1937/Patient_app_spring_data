package org.example.patient_app.service;

import org.example.patient_app.entities.Consultation;
import org.example.patient_app.entities.Medecin;
import org.example.patient_app.entities.Patient;
import org.example.patient_app.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
