package com.medici.app.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.cloud.gcp.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.google.cloud.spanner.Key;
import com.medici.app.entity.Trade;

@RepositoryRestResource(collectionResourceRel = "trades", path = "trades")
public interface TradeRepository extends SpannerRepository<Trade, Key> {

	List<Trade> findTop3DistinctByActionAndSymbolOrTraderIdOrderBySymbolDesc(String action, String symbol, String traderId);

	List<Trade> findByAction(String action);

	@Query("SELECT * FROM trades limit 1")
	Trade getAnyOneTrade();

	@Query("SELECT trade_id from trades where action = @action")
	List<String> getTradeIds(@Param("action") String action);

	int countByAction(String action);

	List<Trade> fetchByActionNamedQuery(@Param("tag0") String action);

}
