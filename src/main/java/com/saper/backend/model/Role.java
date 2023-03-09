package com.saper.backend.model;

import com.saper.backend.enums.RoleNames;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    RoleNames role;

    @Override
    public String getAuthority() {
        return role.toString();
    }
}
