package com.optigra.shortener.service.url;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.optigra.shortener.dao.Dao;
import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;
import com.optigra.shortener.service.generator.UrlGenerator;

@Component("urlShortenerService")
public class DefaultUrlShortenerService implements UrlShortenerService {

	@Resource(name = "redisUrlDao")
	private Dao<ShortUrl, String> shortUrlDao;
	
	@Resource(name = "urlGenerator")
	private UrlGenerator urlGenerator;
	
	@Override
	public ShortUrl storeUrl(final Url url) {
		ShortUrl shortUrl = urlGenerator.generateShortUrl(url);
		shortUrlDao.save(shortUrl);
		
		return shortUrl;
	}

	@Override
	public ShortUrl getUrl(final String shortUrl) {
		return shortUrlDao.findById(shortUrl);
	}

}
