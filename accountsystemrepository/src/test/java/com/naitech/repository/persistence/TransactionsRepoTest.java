package com.naitech.repository.persistence;

import com.naitech.repository.Config.RepoTestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepoTestConfig.class)
public class TransactionsRepoTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllTransactions() {
    }

    @Test
    public void deleteByMemberId() {
    }
}