package com.naitech.translator.config;


import com.naitech.repository.Config.RepositoryConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = "com.naitech.translator")
public class TranslatorConfig {
}
