package com.example.FINAL.service.serviceimpl;

import com.example.FINAL.dto.RegistrationDto;
import com.example.FINAL.models.Role;
import com.example.FINAL.models.UserEntity;
import com.example.FINAL.repository.RoleRepository;
import com.example.FINAL.repository.UserRepository;
import com.example.FINAL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository rolerepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository rolerepository,PasswordEncoder passwordEncoder) {
        this.rolerepository = rolerepository;
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity userEntity=new UserEntity();
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setUsername(registrationDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        Role role=rolerepository.findByName("USER");
        userEntity.setRoles(Arrays.asList(role));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
