package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.CategorieActe;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prixDeBase;
    private CategorieActe categorieActe;
    private String libelle;

    @OneToMany(mappedBy = "acte",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<InterventionMedcin> interventionsMedcin;
}
