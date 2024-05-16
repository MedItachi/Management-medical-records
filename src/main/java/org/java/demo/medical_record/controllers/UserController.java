package org.java.demo.medical_record.controllers;

import org.java.demo.medical_record.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public String index(Model    model) {
        return "secretary/test";
    }
}
