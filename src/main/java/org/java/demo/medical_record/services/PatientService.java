package org.java.demo.medical_record.services;


import lombok.AllArgsConstructor;
import org.java.demo.medical_record.dto.PatientDto;
import org.java.demo.medical_record.entities.Patient;
import org.java.demo.medical_record.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PatientService {
    private ModelMapper modelMapper;
    private PatientRepository patientRepository;

//    getAllPatients() method
    public List<PatientDto> getAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
    }

    public  void  deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public void addPatient(PatientDto patientDto) {
        patientRepository.save(modelMapper.map(patientDto, Patient.class));
    }

}
