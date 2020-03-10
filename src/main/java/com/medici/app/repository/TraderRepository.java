package com.medici.app.repository;

import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.medici.app.entity.Trader;

@RepositoryRestResource(collectionResourceRel = "traders", path = "traders")
public interface TraderRepository extends SpannerRepository<Trader, String> {

}
