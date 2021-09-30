package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Driving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingRepo extends JpaRepository<Driving, Long> {
}
