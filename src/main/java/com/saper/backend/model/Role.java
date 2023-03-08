package com.saper.backend.model;

import com.saper.backend.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}
