package com.fitdine.order.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(value = {"com.fitdine.order.domain.entity"})
@EnableJpaRepositories(value = {"com.fitdine.order.domain"})
@ComponentScan(basePackages = {"com.fitdine.order.common", "com.fitdine.order.domain"})
public class DomainConfig {

}
