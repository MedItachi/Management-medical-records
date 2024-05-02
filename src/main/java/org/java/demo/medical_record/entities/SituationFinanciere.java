package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SituationFinanciere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreation;
    private double montantRestant;
    private double montantGlobal;
    @OneToMany(mappedBy = "situationFinanciere")
    private List<Facture> facture;
    @ManyToOne
    @JoinColumn(name = "caisse_id",nullable = false)
    private Caisse caisse;





}
