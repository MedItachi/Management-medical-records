package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.GroupeSanguin;
import org.java.demo.medical_record.enums.Mutuelle;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Patient extends Personne {

    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Mutuelle mutuelle;
    @Enumerated(EnumType.STRING)
    private GroupeSanguin groupeSanguin;
    @ManyToMany
    @JoinTable(name = "patient_antecedent", joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "antecedent_id"))
    private List<AntecedentMedical> antecedents;

    @OneToOne(mappedBy = "patient")
    private DossierMedical dossierMedical;

}
