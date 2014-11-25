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
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/urls")
@Api(value = "Url Controller", description = "Controller, that describes url")
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
	@ApiOperation(value = "Get's full url")
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
	@ApiOperation(value = "Creates new short url")
	public UrlResource createPicture(@RequestBody final UrlResource urlResource) {
		LOG.info("Creating Url resource with: {}", urlResource);
		return urlShortenerFacade.storeUrl(urlResource);
	}
	
}
