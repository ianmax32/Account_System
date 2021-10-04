package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Health_fitness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Health_fitness_repo extends JpaRepository<Health_fitness, Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from driving where member_id=:id",nativeQuery = true)
    public void deleteByMemberId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update health_fitness set health_fitness_current_amount=:goal where member_id=:id",nativeQuery = true)
    public void updateByMemberId(@Param("id") Long id, @Param("goal") double goal);

    @Query(value = "select health_fitness_current_amount from health_fitness where member_id=:id",nativeQuery = true)
    public double getCurHFValueByMemberId(@Param("id") Long id);

    @Query(value = "select health_fitness_week_goal from health_fitness where member_id=:id",nativeQuery = true)
    public double getGoalToMeetHF(@Param("id") Long id);
}
