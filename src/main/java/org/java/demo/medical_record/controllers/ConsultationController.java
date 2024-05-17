package org.java.demo.medical_record.controllers;

import lombok.AllArgsConstructor;
import org.java.demo.medical_record.dto.ConsultationDto;
import org.java.demo.medical_record.services.ConsultationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/consultations")
@AllArgsConstructor
public class ConsultationController {

    private ConsultationService consultationService;
    @GetMapping
    public String addConsultation(Model model){
        model = consultationService.startConsultation(model,"ORTHODONTIE");
        model.addAttribute("consultationDTO", new ConsultationDto());
        return "consultation/addConsultation";
    }

    @PostMapping("/save")
    public String saveConsultation(@ModelAttribute ConsultationDto consultationDTO){
        consultationService.saveConsultation(consultationDTO);
        return "redirect:/consultations/list";
    }

    @GetMapping("/list")
    public String listConsultation(Model model){
        model.addAttribute("consultations",consultationService.getAllConsultation());
        return "consultation/listConsultation";
    }


}
