package com.saper.backend.repository;

import com.saper.backend.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface BoxRespository extends JpaRepository<Box, Long> {
    List<Box> findAllByNameIgnoreCase(String name);

    List<Box> findAllByNameContainingIgnoreCaseAndCapacityGreaterThanEqualAndCapacityLessThanEqual(String name, int min, int max);
}
