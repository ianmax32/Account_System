package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Driving;
import com.naitech.domain.persistence.Health_fitness;
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

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepoTestConfig.class)
public class Health_fitness_repoTest {

    @Autowired
    private Health_fitness_repo health_fitness_repo;

    @Autowired
    private MemberRepo memberRepo;


    @Before
    public void setUp() throws Exception {
        Member member= new Member(null,"Ian","Masaga", LocalDate.now(),"Male",0,0);
        memberRepo.save(member);
        Health_fitness driving = new Health_fitness(
                null,
                250,
                50,
                member
        );
        health_fitness_repo.save(driving);
    }

    @Test
    public void deleteByMemberId() {
       /* Member member= new Member(null,"Sean","Matemba", LocalDate.now(),"Male",0,0);
        memberRepo.save(member);
        Health_fitness driving = new Health_fitness(
                null,
                250,
                68,
                member
        );
        health_fitness_repo.saveAndFlush(driving);*/

        health_fitness_repo.deleteByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber());
        assertEquals((1),health_fitness_repo.count());
    }

    @Test
    public void updateByMemberId() {
        Health_fitness one = health_fitness_repo.getOne(memberRepo.getID("Ian","Masaga").getIdNUmber());
        one.setCurrent_amount(35);
        health_fitness_repo.save(one);
        //health_fitness_repo.updateByMemberId(memberRepo.getID("Sean","Matemba").getIdNUmber(),35);
        assertEquals((Double)35.0,(Double) health_fitness_repo.getOne(memberRepo.getID("Ian","Masaga").getIdNUmber()).getCurrent_amount());
    }

    @Test
    public void getCurHFValueByMemberId() {
        assertEquals((Object) 50.0,(Object)health_fitness_repo.getCurHFValueByMemberId(memberRepo.getID("Ian","Masaga").getIdNUmber()));
    }

    @Test
    public void getGoalToMeetHF() {
        assertEquals((Object) 250.0,(Object)health_fitness_repo.getGoalToMeetHF(memberRepo.getID("Ian","Masaga").getIdNUmber()));

    }
}