package com.naitech.repository.persistence;

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
public class Rewards_CategoriesRepoTest {

    @Autowired
    private Rewards_CategoriesRepo rewards_categoriesRepo;

    @Before
    public void setUp() throws Exception {
        rewards_categoriesRepo.save(new RewardsCategories(
                null,
                "Technology",
                "Keyboard"
        ));
    }

    @Test
    public void getRewardsCategoryUniqueName() {
        assertEquals("Keyboard",rewards_categoriesRepo.getRewardsCategoryUniqueName("Keyboard").getCategory_Type());
    }
}