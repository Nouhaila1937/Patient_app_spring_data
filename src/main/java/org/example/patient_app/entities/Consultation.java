package org.example.patient_app.entities;

import jakarta.persistence.*;
import org.example.patient_app.entities.RendezVous;
import java.util.Date;

@Entity
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rapport;
    private Date dateconsultation;
    @OneToOne
    private RendezVous rendezVous;
}
