package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.TypePaiment;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double montantRestant;
    private double montantPaye;
    private double montantTotal;
    private Date dateFacturation;

    @Enumerated(EnumType.STRING)
    private TypePaiment typePaiment;
    @ManyToOne
    @JoinColumn(name = "situation_financiere_id",nullable = false)
    private SituationFinanciere situationFinanciere;
    @ManyToOne
    @JoinColumn(name = "consultation_id",nullable = false)
    private Consultation consultation;
}
