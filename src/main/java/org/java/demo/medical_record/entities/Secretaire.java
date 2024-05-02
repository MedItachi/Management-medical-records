package org.java.demo.medical_record.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.Assurance;
import org.java.demo.medical_record.enums.StatusEmploye;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Secretaire extends  Utlisateur {
    private double slaireDeBase;
    @Enumerated(EnumType.STRING)
    private Assurance assurance;
    @Enumerated(EnumType.STRING)
    private StatusEmploye statusEmploye;
    private  double prime;
}
