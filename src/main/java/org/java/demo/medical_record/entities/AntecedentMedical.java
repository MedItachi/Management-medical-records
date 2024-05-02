package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.CategorieAntecedentsMedicaux;
import org.java.demo.medical_record.enums.Risque;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AntecedentMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private CategorieAntecedentsMedicaux categorieAntecedentsMedicaux;
    @Enumerated(EnumType.STRING)
    private Risque risque;

    @ManyToMany(mappedBy = "antecedents")
    private List<Patient> patients;


}
