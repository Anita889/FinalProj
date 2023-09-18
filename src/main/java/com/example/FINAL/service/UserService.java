package com.example.FINAL.service;

import com.example.FINAL.dto.RegistrationDto;
import com.example.FINAL.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);

}
