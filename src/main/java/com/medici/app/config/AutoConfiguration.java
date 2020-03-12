package com.medici.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.gcp.data.spanner.repository.config.EnableSpannerAuditing;
import org.springframework.cloud.gcp.data.spanner.repository.config.EnableSpannerRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.medici.app.driver.SpannerTemplateManager;
import com.medici.app.entity.Trade;
import com.medici.app.entity.Trader;
import com.medici.app.repository.TradeRepository;
import com.medici.app.repository.TraderRepository;

@Configuration
@EntityScan(basePackageClasses = { Trader.class, Trade.class })
@EnableTransactionManagement
@EnableSpannerAuditing
@EnableSpannerRepositories(basePackageClasses = { TraderRepository.class, TradeRepository.class })
public class AutoConfiguration {

	@Autowired
	private SpannerTemplateManager spannerTemplateManager;

	@Bean
	ApplicationRunner applicationRunner() {

		return (args) -> {

			spannerTemplateManager.createTables();

		};

	}

}
