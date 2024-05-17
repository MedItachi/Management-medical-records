package org.java.demo.medical_record.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
//localhost:8080/patients
//lombok
@AllArgsConstructor
public class DashbordController {

        //    pas data to the view
        @GetMapping
        public String getDashbord() {
            return "dashbord/index";
        }
}
