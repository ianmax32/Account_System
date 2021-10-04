package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Driving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DrivingRepo extends JpaRepository<Driving, Long> {
    @Modifying
    @Transactional
    @Query(value = "delete from driving where member_id=:id",nativeQuery = true)
    public void deleteByMemberId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update driving set driving_current_goal=:goal where member_id=:id",nativeQuery = true)
    public void updateByMemberId(@Param("id") Long id, @Param("goal") double goal);

    @Query(value = "select driving_current_goal from driving where member_id=:id",nativeQuery = true)
    public double getCurValueByMemberId(@Param("id") Long id);

    @Query(value = "select driving_week_goal from driving where member_id=:id",nativeQuery = true)
    public double getGoalToMeetDriving(@Param("id") Long id);
}
