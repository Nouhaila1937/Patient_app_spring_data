package org.example.patient_app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor
@AllArgsConstructor
public class Medecin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String specialite;
    private String email;
    @OneToMany(mappedBy = "medecin",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;

}
