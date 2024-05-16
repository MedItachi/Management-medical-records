package org.java.demo.medical_record.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.enums.GroupeSanguin;
import org.java.demo.medical_record.enums.Mutuelle;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private Mutuelle mutuelle;
    private GroupeSanguin groupeSanguin;
}
