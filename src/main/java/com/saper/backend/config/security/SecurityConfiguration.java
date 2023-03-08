package com.saper.backend.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/clients/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/clients/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/clients/**").authenticated()
                .anyRequest().authenticated();
        http.csrf().disable();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}