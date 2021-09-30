package com.naitech.repository.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.naitech.repository.persistence")
@EntityScan("com.naitech.domain.persistence")
@PropertySource(value = "classpath:application-database.properties")
public class RepositoryConfig {
}
