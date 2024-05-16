package org.java.demo.medical_record.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonneDto {
    private String nom;
    private String prenom;
    private String telephone;
    private String salaire;
}
