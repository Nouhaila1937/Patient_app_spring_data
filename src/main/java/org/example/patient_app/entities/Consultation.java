package org.example.patient_app.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.patient_app.entities.RendezVous;
import java.util.Date;

@Entity
@Data@Getter
@Setter
public class Consultation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rapport;
    private Date dateconsultation;
    @OneToOne
    private RendezVous rendezVous;
}
