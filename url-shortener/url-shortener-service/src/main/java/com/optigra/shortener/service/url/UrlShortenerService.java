package com.optigra.shortener.service.url;

import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;

/**
 * Main service for working with urls.
 * @author ivanursul
 *
 */
public interface UrlShortenerService {

	/**
	 * Method for storing urls.
	 * @param url
	 * @return url with generated shortUrl.
	 */
	ShortUrl storeUrl(Url url);

	/**
	 * Method for getting ready url
	 * @param shortUrl
	 * @return
	 */
	ShortUrl getUrl(String shortUrl);

}
