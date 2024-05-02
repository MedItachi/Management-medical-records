package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.TypeConsultation;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dossier_medical_id")
    private DossierMedical dossierMedical;
    private Date dateConsultation;

    @Enumerated(EnumType.STRING)
    private TypeConsultation typeConsultation;

   @OneToMany(mappedBy = "consultation")
    private List<Facture> factures;

   @OneToMany(mappedBy = "consultation")
   private List<InterventionMedcin> interventions;





}
