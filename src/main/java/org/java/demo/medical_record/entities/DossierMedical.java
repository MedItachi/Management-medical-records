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
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToMany(mappedBy = "dossierMedical",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<Consultation>  consultations;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "situation_financiere_id",referencedColumnName = "id")
    private SituationFinanciere situationFinanciere;
    @ManyToOne
    @JoinColumn(name = "dentiste_id")
    private Dentiste dentist;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;


}
