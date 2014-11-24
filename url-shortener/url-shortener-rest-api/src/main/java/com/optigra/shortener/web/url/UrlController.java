package com.optigra.shortener.web.url;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.facade.url.UrlShortenerFacade;

@RestController
@RequestMapping(value = "/url")
public class UrlController {

	private static final Logger LOG = LoggerFactory.getLogger(UrlController.class);

	@Resource(name = "urlShortenerFacade")
	private UrlShortenerFacade urlShortenerFacade;
	
	
	/**
	 * API for getting Url by shortUrl.
	 * 
	 * @param shortUrl Url for search.
	 * @return Serialized UrlResource with required fields.
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{shortUrl}", method = RequestMethod.GET)
	public UrlResource getUrl(@PathVariable("shortUrl") final String shortUrl){
		LOG.info("Retrieving Url from Short Url");
		UrlResource resource = urlShortenerFacade.getUrl(shortUrl);
		return resource;
	}

}
