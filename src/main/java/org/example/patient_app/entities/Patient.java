package org.example.patient_app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor@Getter@Setter
public class Patient {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE) // pour garder uniquement la date pas d'heure et tout
    private Date dateOfBirth;
    private boolean malade;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
