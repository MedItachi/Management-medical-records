package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterventionMedcin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double prixPatient;
    private double dent;
    @ManyToOne
    @JoinColumn(name="acte_id")
    private Acte acte;

    @ManyToOne
    @JoinColumn(name="consultation_id")
    private Consultation consultation;
}
