package com.example.springsecuritych6.repository;

import com.example.springsecuritych6.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String u);
}
