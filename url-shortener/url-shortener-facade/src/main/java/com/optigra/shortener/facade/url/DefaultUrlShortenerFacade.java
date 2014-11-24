package com.optigra.shortener.facade.url;

import org.springframework.stereotype.Component;

import com.optigra.shortener.facade.resource.url.UrlResource;

@Component("urlShortenerFacade")
public class DefaultUrlShortenerFacade implements UrlShortenerFacade {

	@Override
	public UrlResource storeUrl(final UrlResource url) {
		return null;
	}

	@Override
	public UrlResource getUrl(final String shortUrl) {
		return null;
	}

}
