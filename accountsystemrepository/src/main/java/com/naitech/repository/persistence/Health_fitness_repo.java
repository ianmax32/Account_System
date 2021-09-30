package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Health_fitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Health_fitness_repo extends JpaRepository<Health_fitness, Long> {
}
