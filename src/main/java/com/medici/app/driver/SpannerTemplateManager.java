package com.medici.app.driver;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.data.spanner.core.SpannerOperations;
import org.springframework.cloud.gcp.data.spanner.core.admin.SpannerDatabaseAdminTemplate;
import org.springframework.cloud.gcp.data.spanner.core.admin.SpannerSchemaUtils;
import org.springframework.stereotype.Component;

import com.medici.app.entity.Trade;
import com.medici.app.entity.Trader;

@Component
public class SpannerTemplateManager {

	@Autowired
	private SpannerOperations spannerOperations;

	@Autowired
	private SpannerSchemaUtils spannerSchemaUtils;

	@Autowired
	private SpannerDatabaseAdminTemplate spannerDatabaseAdminTemplate;

	public void createTables() {

		if (!this.spannerDatabaseAdminTemplate.tableExists("trades"))
			this.spannerDatabaseAdminTemplate.executeDdlStrings(Arrays.asList(this.spannerSchemaUtils.getCreateTableDdlString(Trade.class)), true);

		if (!this.spannerDatabaseAdminTemplate.tableExists("traders"))
			this.spannerDatabaseAdminTemplate.executeDdlStrings(Arrays.asList(this.spannerSchemaUtils.getCreateTableDdlString(Trader.class)), true);

	}

}
