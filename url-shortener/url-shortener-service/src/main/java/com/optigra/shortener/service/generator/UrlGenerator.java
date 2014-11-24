package com.optigra.shortener.service.generator;

import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;

/**
 * Url generator.
 * @author ivanursul
 *
 */
public interface UrlGenerator {

	/**
	 * MEthod for generating short Url.
	 * @param url
	 * @return
	 */
	ShortUrl generateShortUrl(Url url);

}
