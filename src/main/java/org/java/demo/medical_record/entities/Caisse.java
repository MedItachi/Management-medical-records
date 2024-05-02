package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double recetteDuJours;
    private double recetteDuMois;
    private double recetteAnnee;

    @OneToMany(mappedBy = "caisse")
    private List<SituationFinanciere> situationsFinancieres;


}
