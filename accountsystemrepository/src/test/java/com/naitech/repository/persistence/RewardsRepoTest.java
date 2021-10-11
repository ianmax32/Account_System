package com.naitech.repository.persistence;

import com.naitech.domain.persistence.Rewards;
import com.naitech.domain.persistence.RewardsCategories;
import com.naitech.repository.Config.RepoTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepoTestConfig.class)
public class RewardsRepoTest {

    @Autowired
    private RewardsRepo rewardsRepo;

    @Before
    public void setUp() throws Exception {
        
        rewardsRepo.save(new Rewards(null,"Coffee",new RewardsCategories(null,
                "Technology",
                "Keyboard"),15));
    }

    @Test
    public void updateRewardPrices() {
    }
}