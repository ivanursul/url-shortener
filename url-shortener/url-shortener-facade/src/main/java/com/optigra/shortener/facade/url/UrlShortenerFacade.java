package com.optigra.shortener.facade.url;

import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.facade.resource.url.UrlResource;

/**
 * Main interface in facade layer.
 * @author ivanursul
 *
 */
public interface UrlShortenerFacade {

	/**
	 * Method for storing url.
	 * @param url
	 * @return ready short url object.
	 */
	UrlResource storeUrl(UrlResource url);
	
	/**
	 * Method for getting short url.
	 * @param shortUrl
	 * @return short url
	 */
	ShortUrlResource getUrl(String shortUrl);
}
