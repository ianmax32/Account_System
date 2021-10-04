package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RewardsRepo extends JpaRepository<Rewards, Long> {
    @Modifying
    @Transactional
    @Query(value = "update rewards set reward_amount=:amount where reward_id=:id",nativeQuery = true)
    public void updateRewardPrices(@Param("id") Long id, @Param("amount") double amount);
}
