package com.naitech.repository.persistence;

import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.RewardsCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Rewards_CategoriesRepo extends JpaRepository<RewardsCategories, Long> {
    @Query(value = "select * from rewards_categories where rewards_category_type=:name",nativeQuery = true)
    public RewardsCategories getRewardsCategoryUniqueName(@Param("name") String name);
}
