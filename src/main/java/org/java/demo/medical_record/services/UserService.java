package org.java.demo.medical_record.services;

import org.java.demo.medical_record.dto.CreateUserDto;
import org.java.demo.medical_record.dto.UserDto;

import java.util.List;

public interface UserService {

    boolean login(String username, String password);

    boolean register(CreateUserDto createUserDto);
    String HashPassword(String password);
    UserDto getUser(String username);
}
