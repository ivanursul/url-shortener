package com.optigra.shortener.service.generator;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.optigra.shortener.dao.Dao;
import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;

@Component("urlGenerator")
public class DefaulUrlGenerator implements UrlGenerator {

	@Resource(name = "redisShortUrlMappingDao")
	private Dao<Url, Long> shortUrlMappingDao;
	
	@Resource(name = "base62Converter")
	private Base62Converter converter;

	@Override
	public ShortUrl generateShortUrl(final Url url) {
		Long shorUrlMappingId = shortUrlMappingDao.save(url);
		String shortUrlLink = converter.convertTo62Base(shorUrlMappingId);
		
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setUrl(url.getUrl());
		shortUrl.setShortUrl(shortUrlLink);
		
		return shortUrl;
	}

}
