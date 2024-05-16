package org.java.demo.medical_record.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "password is required")
    @Size(min = 4, message = "Password must be at least 4 characters")
    private String password;
    @NotBlank(message = "nom is required")
    private String nom;
    @NotBlank(message = "Prenom is required")
    private String prenom;
    @NotNull(message = "Roles are required")
    @Size(min = 1, message = "At least one role must be selected")
    private List<Long> roles;
 }
