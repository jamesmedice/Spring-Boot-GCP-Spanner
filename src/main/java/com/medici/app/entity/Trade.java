package com.medici.app.entity;

import java.util.List;

import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

/**
 * 
 * @author a73s
 *
 */
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
@lombok.Getter
@lombok.Setter
@lombok.Builder
@lombok.ToString
@Table(name = "trades")
public class Trade {

	@PrimaryKey(keyOrder = 2)
	@Column(name = "trade_id")
	private String tradeId;

	@PrimaryKey(keyOrder = 1)
	@Column(name = "trader_id")
	private String traderId;

	private String action;

	private Double price;

	private Double shares;

	private String symbol;

	private List<Double> curve;
}
