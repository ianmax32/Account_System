package com.naitech.webservices.config;

import com.naitech.logic.config.LogicConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = "com.naitech.wsb.Controllers")
public class WebConfig {
}
