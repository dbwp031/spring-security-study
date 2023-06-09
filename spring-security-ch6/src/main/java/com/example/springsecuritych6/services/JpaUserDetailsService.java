package com.example.springsecuritych6.services;

import com.example.springsecuritych6.entities.User;
import com.example.springsecuritych6.model.CustomUserDetails;
import com.example.springsecuritych6.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username){
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

        User u = userRepository
                .findByUsername(username)
                .orElseThrow(s);

        return new CustomUserDetails(u);
    }
}
