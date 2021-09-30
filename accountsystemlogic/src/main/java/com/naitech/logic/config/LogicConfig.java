package com.naitech.logic.config;

import com.naitech.translator.config.TranslatorConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = "com.naitech.logic.flow")
public class LogicConfig {
}
