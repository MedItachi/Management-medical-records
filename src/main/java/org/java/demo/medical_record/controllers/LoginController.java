package org.java.demo.medical_record.controllers;


import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.java.demo.medical_record.dto.UserDto;
import org.java.demo.medical_record.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private UserService userService;

    @RequestMapping
    public String login(){
        return "login/login";
    }

    @PostMapping("/dashbord")
    public String dashbord(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (userService.login(username, password)) {
            UserDto userDto = userService.getUser(username);
            session.setAttribute("user", userDto);
            return "redirect:/dashbord";
        }
        return "redirect:/login?error=true";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate session to clear all session attributes
        session.invalidate();
        // Redirect to the login page after logout
        return "redirect:/login";
    }
}
