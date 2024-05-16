package org.java.demo.medical_record.controllers;

import lombok.AllArgsConstructor;
import org.java.demo.medical_record.dto.PatientDto;
import org.java.demo.medical_record.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//localhost:8080/patients
//lombok
 @AllArgsConstructor
 @RequestMapping("/patients")
public class PatientController {

    private PatientService patientService;

//    pas data to the view
    @GetMapping
    public String getAllPatients(Model model) {
        List<PatientDto> patients = patientService.getAllPatients();
        model.addAttribute("patients", patients);
        return "patients/listPatients";


    }

    @GetMapping("/addPatient")
    public String addPatient(){
        return "patients/addPatient";
    }

    @PostMapping("/addPatient")
    public String addPatient(@RequestBody PatientDto patientDto){
        patientService.addPatient(patientDto);
        System.out.println(patientDto);
        System.out.println("-----------------");
        return "redirect:/patients";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id){
        Long patientId = Math.abs(id);
        patientService.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }
}