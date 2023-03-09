package com.saper.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/clients").permitAll()
                .requestMatchers("/my/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
                .anyRequest().hasAnyRole("ADMIN", "PROFESSOR");
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
