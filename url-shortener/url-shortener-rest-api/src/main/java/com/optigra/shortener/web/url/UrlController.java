package com.optigra.shortener.web.url;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.facade.url.UrlShortenerFacade;
import com.optigra.shortener.web.BaseController;

@Controller
@RequestMapping(value = "/urls")
public class UrlController extends BaseController {

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
	public RedirectView getUrl(@PathVariable("shortUrl") final String shortUrl,
			final HttpServletResponse httpServletResponse){
		LOG.info("Retrieving Url from Short Url");
		ShortUrlResource resource = urlShortenerFacade.getUrl(shortUrl);
		
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(resource.getUrl());
		
		return redirectView;
	}


    /**
	 * Method for posting Url.
	 * @param  urlResource resource to store.
	 * @return resource resource.
	 */
	@ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public UrlResource createPicture(@RequestBody final UrlResource urlResource) {
		LOG.info("Creating Url resource with: {}", urlResource);
		return urlShortenerFacade.storeUrl(urlResource);
	}
	
}
