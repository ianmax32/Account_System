package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards, Long> {
}
