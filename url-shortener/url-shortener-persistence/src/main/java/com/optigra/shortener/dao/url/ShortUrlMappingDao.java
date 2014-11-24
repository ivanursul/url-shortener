package com.optigra.shortener.dao.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.optigra.shortener.dao.AbstractDao;
import com.optigra.shortener.model.url.Url;

@Repository("shortUrlMappingDao")
public class ShortUrlMappingDao extends AbstractDao<Url, Long> {

	@Value("1")
	private Long autoIncrementId;
	
	@Override
	public Long save(final Url entity) {
		Long id = autoIncrementId++;
		getMap().put(id, entity);
		return id;
	}

}
