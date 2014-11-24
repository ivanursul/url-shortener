package com.optigra.shortener.dao.url;

import org.springframework.stereotype.Repository;

import com.optigra.shortener.dao.AbstractDao;
import com.optigra.shortener.model.url.ShortUrl;

@Repository("urlDao")
public class UrlDao extends AbstractDao<ShortUrl, String> {

	@Override
	public String save(final ShortUrl entity) {
		getMap().put(entity.getShortUrl(), entity);
		return entity.getShortUrl();
	}

}
