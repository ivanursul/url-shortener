package com.optigra.shortener.facade.url;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.optigra.shortener.facade.converter.Converter;
import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;
import com.optigra.shortener.service.url.UrlShortenerService;

@Component("urlShortenerFacade")
public class DefaultUrlShortenerFacade implements UrlShortenerFacade {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultUrlShortenerFacade.class);
	
	@Resource(name = "urlResourceConverter")
	private Converter<UrlResource, Url> urlResourceConverter;
	
	@Resource(name = "urlConverter")
	private Converter<ShortUrl, ShortUrlResource> urlConverter;
	
	@Resource(name = "urlShortenerService")
	private UrlShortenerService urlShortenerService;
	
	@Override
	public UrlResource storeUrl(final UrlResource resource) {
		LOG.info("Generating new url for: {}", resource);
		
		Url url = urlResourceConverter.convert(resource);
		ShortUrl storedUrl = urlShortenerService.storeUrl(url);
		
		return urlConverter.convert(storedUrl);
	}

	@Override
	public ShortUrlResource getUrl(final String shortUrl) {
		LOG.info("Getting short url for: {}", shortUrl);
		
		ShortUrl url = urlShortenerService.getUrl(shortUrl);
		return urlConverter.convert(url);
	}

}
