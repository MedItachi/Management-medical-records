package org.java.demo.medical_record.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashbord") // Define the mapping path here
@AllArgsConstructor
public class DashbordController {

        //    pas data to the view
        @GetMapping
        public String getDashbord() {
            return "dashbord/index";
        }
}
