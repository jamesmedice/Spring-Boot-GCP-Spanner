package com.medici.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.medici.app.driver.SpannerTemplateManager;

@Configuration
@EnableAutoConfiguration
public class AutoConfiguration {

	@Autowired
	private SpannerTemplateManager spannerTemplateManager;

	@Bean
	@Profile("spanner")
	ApplicationRunner applicationRunner() {

		return (args) -> {

			spannerTemplateManager.createTables();

		};

	}

}