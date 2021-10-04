package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Spending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SpendingRepo extends JpaRepository<Spending, Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from driving where member_id=:id",nativeQuery = true)
    public void deleteByMemberId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update spending set current_amount_spent=:goal where member_id=:id",nativeQuery = true)
    public void updateByMemberId(@Param("id") Long id, @Param("goal") double goal);

    @Query(value = "select current_amount_spent from spending where member_id=:id",nativeQuery = true)
    public double getCurSpendingValueByMemberId(@Param("id") Long id);

    @Query(value = "select weekly_goal from spending where member_id=:id",nativeQuery = true)
    public double getGoalToMeetSpending(@Param("id") Long id);
}
