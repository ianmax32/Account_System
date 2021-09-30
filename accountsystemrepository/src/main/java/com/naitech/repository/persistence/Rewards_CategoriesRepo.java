package com.naitech.repository.persistence;

import com.naitech.domain.persistence.RewardsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rewards_CategoriesRepo extends JpaRepository<RewardsCategories, Long> {
}
