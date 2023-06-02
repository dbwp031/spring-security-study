package com.example.ch11.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Otp {
    @Id
    private String username;
    private String code;

}
