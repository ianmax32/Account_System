package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Member;
import com.naitech.repository.Config.RepoTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.sun.javaws.JnlpxArgs.verify;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepoTestConfig.class)
public class DrivingRepoTest {

    @Autowired
    private DrivingRepo drivingRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Before
    public void setUp() throws Exception {
        Member member= new Member(null,"Ian","Masaga", LocalDate.now(),"Male",0,0);
        memberRepo.save(member);
        Driving driving = new Driving(
                null,
                10,
                60,
                member
        );
        drivingRepo.save(driving);
    }

    @Test
    public void updateByMemberId() {
       /* Driving one = drivingRepo.getOne(memberRepo.getID("Ian","Masaga").getIdNUmber());
        one.setWeek_goal_km(45);
        drivingRepo.save(one);*/
        drivingRepo.updateByMemberId(Long.parseLong(String.valueOf(1)),45);
        assertEquals((Object)45.0,(Object)drivingRepo.getOne(Long.parseLong(String.valueOf(1))).getWeek_goal_km());
    }

    @Test
    public void getCurValueByMemberId() {
        Double curValueByMemberId = drivingRepo.getCurValueByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber());
        assertEquals((Object) curValueByMemberId,(Object)drivingRepo.getCurValueByMemberId(Long.parseLong(String.valueOf(1))));
    }

    @Test
    public void getGoalToMeetDriving() {
        /*Driving one = drivingRepo.getOne(memberRepo.getID("Ian","Masaga").getIdNUmber());
        one.setKm(60);
        drivingRepo.save(one);*/
        Double goalToMeetDriving = drivingRepo.getGoalToMeetDriving(Long.parseLong(String.valueOf(1)));
        assertEquals((Object)goalToMeetDriving, (Object) drivingRepo.getGoalToMeetDriving(Long.parseLong(String.valueOf(1))));
    }

    @Test
    public void deleteByMemberId() {
        drivingRepo.deleteByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber());
        assertNull(drivingRepo.getCurValueByMemberId(Long.parseLong(String.valueOf(1))));
    }
}