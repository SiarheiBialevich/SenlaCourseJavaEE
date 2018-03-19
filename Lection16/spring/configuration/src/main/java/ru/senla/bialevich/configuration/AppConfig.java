package ru.senla.bialevich.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "ru.senla.bialevich")
@EnableWebMvc
public class AppConfig {

}
