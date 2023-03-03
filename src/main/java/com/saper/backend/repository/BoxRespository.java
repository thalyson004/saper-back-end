package com.saper.backend.repository;

import com.saper.backend.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRespository extends JpaRepository<Box, Long> {
}
