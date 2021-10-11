package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Health_fitness;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Spending;
import com.naitech.repository.Config.RepoTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepoTestConfig.class)
public class SpendingRepoTest {

    @Autowired
    private SpendingRepo spendingRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Before
    public void setUp() throws Exception {
        Member member= new Member(null,"Ian","Masaga", LocalDate.now(),"Male",0,0);
        memberRepo.save(member);
        Spending driving = new Spending(
                null,
                1500,
                1000,
                member
        );
        spendingRepo.save(driving);
    }

    @Test
    public void deleteByMemberId() {
        spendingRepo.deleteByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber());
        assertEquals((1),spendingRepo.count());
    }

    @Test
    public void updateByMemberId() {
        Spending spending = spendingRepo.getOne(memberRepo.getID("Ian","Masaga").getIdNUmber());
        spending.setCurrent_amount_spent(1300);
        spendingRepo.save(spending);
        //spendingRepo.updateByMemberId(memberRepo.getID("Sean","Matemba").getIdNUmber(),35);
        assertEquals((Double)1300.0,(Double) spendingRepo.getCurSpendingValueByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber()));
    }

    @Test
    public void getCurSpendingValueByMemberId() {
        assertEquals((Object) 1000.0,(Object)spendingRepo.getCurSpendingValueByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber()));
    }

    @Test
    public void getGoalToMeetSpending() {
        assertEquals((Object) 1500.0,(Object)spendingRepo.getGoalToMeetSpending(memberRepo.getID("Ian","Masaga").getIdNUmber()));
    }
}