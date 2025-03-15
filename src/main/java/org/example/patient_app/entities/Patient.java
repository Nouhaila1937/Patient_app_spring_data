package org.example.patient_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    @Temporal(TemporalType.DATE) // pour garder uniquement la date pas d'heure et tout
    private Date dateOfBirth;
    private boolean malade;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
