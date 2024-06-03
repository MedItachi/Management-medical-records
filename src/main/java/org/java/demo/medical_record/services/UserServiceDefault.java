package org.java.demo.medical_record.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.java.demo.medical_record.dto.CreateUserDto;
import org.java.demo.medical_record.dto.UserDto;
import org.java.demo.medical_record.entities.Role;
import org.java.demo.medical_record.entities.Utlisateur;
import org.java.demo.medical_record.repository.RoleRepository;
import org.java.demo.medical_record.repository.UtilisateurRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.List;
import java.util.Vector;

@Service
@AllArgsConstructor
public class UserServiceDefault implements UserService {

    private  UtilisateurRepository utilisateurRepository;
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;
    @Override
    public boolean login(String username, String password) {

        Utlisateur user = utilisateurRepository.findByUsername(username);
        if(user == null){
            return false;
        }
        return user.getPassword().equals(HashPassword(password));
    }

    @Override
    public boolean register(CreateUserDto createUserDto) {
        if(utilisateurRepository.existsByUsername(createUserDto.getUsername())){

            throw  new RuntimeException("User already exists");
        }

        if(!checkRole(createUserDto.getRoles())){
            throw  new RuntimeException("Role not found");
        }


        Utlisateur user = modelMapper.map(createUserDto, Utlisateur.class);
        user.setPassword(HashPassword(createUserDto.getPassword()));
        user.setRoles(getRoles(createUserDto.getRoles()));
        utilisateurRepository.save(user);


        return true;
    }

    @Override
    public String HashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * encodedHash.length);
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();

        }catch (Exception e){
             return null;
        }
    }

    @Override
    public UserDto getUser(String username) {
        Utlisateur user = utilisateurRepository.findByUsername(username);
        if(user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setRoles(getRoleUser(user));
        return userDto;
    }

    private boolean checkRole(List<Long> roles) {
        for (Long role : roles) {
            if (!roleRepository.existsById(role)) {
                return false;
            }
        }
        return true;
    }

    private List<Role> getRoles(List<Long> roles) {
        return roleRepository.findAllById(roles);
    }

    private  List<String> getRoleUser(Utlisateur user){
        List<Role> roles = user.getRoles();
        List<String> roleNames = new Vector<String>();
        for (Role role : roles) {
            roleNames.add(role.getName());
        }
        return roleNames;
    }

}
