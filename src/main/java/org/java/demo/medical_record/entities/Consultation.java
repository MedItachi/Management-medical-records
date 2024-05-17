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

    private double prixConsultation;
    private Date dateConsultation;
    @ManyToMany
    @JoinTable(name = "consultation_dentiste",
            joinColumns = @JoinColumn(name = "consultation_id"),
            inverseJoinColumns = @JoinColumn(name = "dentiste_id"))
    private List<Dentiste> dentistes;
    @ManyToOne
    @JoinColumn(name ="patient_id")
    private Patient patient;
}
