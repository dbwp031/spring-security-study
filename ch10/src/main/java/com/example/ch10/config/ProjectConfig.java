package com.example.ch10.config;

import com.example.ch10.filters.CsrfTokenLogger;
import com.example.ch10.repositories.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import java.security.Security;

@Configuration
public class ProjectConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        var manager = new InMemoryUserDetailsManager();

        var user1 = User.withUsername("mary")
                .password("12345")
                .authorities("READ")
                .build();

        manager.createUser(user1);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(c -> {
                    c.csrfTokenRepository(customTokenRepository());
                    c.ignoringRequestMatchers("/ciao");
                })
//                .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeHttpRequests(auth ->
                        auth.anyRequest().authenticated())
                .formLogin(f -> f
                        .defaultSuccessUrl("/main",true));
        return http.build();
    }


}
