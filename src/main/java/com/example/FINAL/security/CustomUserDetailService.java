package com.example.FINAL.security;

import com.example.FINAL.models.UserEntity;
import com.example.FINAL.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;
     @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user=userRepository.findByUsername(username);
        if(user!=null)
        {
            User auth=new User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map((role)-> new SimpleGrantedAuthority(role.getName()))
                    .collect(Collectors.toList())
            );
            return auth;
        }
        else {
            throw new UsernameNotFoundException("Invalid username and password");
        }
    }
}
