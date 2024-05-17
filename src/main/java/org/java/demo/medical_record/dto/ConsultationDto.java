package org.java.demo.medical_record.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationDto {
    private LocalDate dateConsultation;
    private Long patientId;
    private double prixConsultation;
    private List<Long> dentisteIds;
}
