//package com.example.ch2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class WebAuthorizationConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.httpBasic(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
//        return http.build();
//    }
//}
