package com.saper.backend.repository;

import com.saper.backend.enums.RoleNames;
import com.saper.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(RoleNames roleUser);
}
