package com.exam.salary.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.exam.salary.repository"})
@EntityScan(basePackages = {"com.exam.salary.domain"})
public class JpaRepositoryConfig {
}
