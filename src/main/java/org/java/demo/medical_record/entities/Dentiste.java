package org.java.demo.medical_record.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.Assurance;
import org.java.demo.medical_record.enums.Disponibilite;
import org.java.demo.medical_record.enums.Specialite;
import org.java.demo.medical_record.enums.StatusEmploye;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Dentiste extends  Utlisateur  {
    private double slaireDeBase;
    private Specialite specialite;
    @Enumerated(EnumType.STRING)
    private Disponibilite disponibilite;
    @Enumerated(EnumType.STRING)
    private Assurance assurance;
    @Enumerated(EnumType.STRING)
    private StatusEmploye statusActuel;


}
