package org.java.demo.medical_record.services;

import lombok.AllArgsConstructor;
import org.java.demo.medical_record.dto.ConsultationDto;
import org.java.demo.medical_record.entities.Consultation;
import org.java.demo.medical_record.entities.Dentiste;
import org.java.demo.medical_record.entities.Patient;
import org.java.demo.medical_record.enums.Specialite;
import org.java.demo.medical_record.repository.ConsultationRepository;
import org.java.demo.medical_record.repository.DentisteRepository;
import org.java.demo.medical_record.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ConsultationService {

      private  DentisteRepository dentisteRepository;
      private PatientRepository patientRepository;
      private ConsultationRepository consultationRepository;
     public Model startConsultation(Model model,String specialite) {
           Specialite specialiteEnum = this.convertStringToSpecialite(specialite);
           model.addAttribute("dentistes",this.getALLDentiste());
           model.addAttribute("patients",this.getALLPatient());
           return model;
     }

    public void saveConsultation(ConsultationDto consultationDto) {
        Consultation consultation = new Consultation();
        consultation.setPrixConsultation(consultationDto.getPrixConsultation());
        // Convert LocalDate to Date
        Date dateConsultation = Date.from(consultationDto.getDateConsultation().atStartOfDay(ZoneId.systemDefault()).toInstant());
        consultation.setDateConsultation(dateConsultation);
        consultation.setPatient(this.getPatientById(consultationDto.getPatientId()));
        consultation.setDentistes(this.getDentisteByIds(consultationDto.getDentisteIds()));
        consultationRepository.save(consultation);

    }

    public  List<Consultation> getAllConsultation() {
        return consultationRepository.findAll();

    }
      private List<Dentiste> getDentisteBySpecialite(Specialite specialite){
          return dentisteRepository.findBySpecialite(specialite);
      }

      private List<Dentiste> getALLDentiste(){
          return dentisteRepository.findAll();
      }

      public List<Patient> getALLPatient(){
          return patientRepository.findAll();
      }

      private Specialite convertStringToSpecialite(String specialite){
          return Specialite.valueOf(specialite);
      }

        private Patient getPatientById(Long id){
            return patientRepository.findById(id).get();
        }

        private List<Dentiste> getDentisteByIds(List<Long> ids){
            return dentisteRepository.findAllById(ids);
        }
}
