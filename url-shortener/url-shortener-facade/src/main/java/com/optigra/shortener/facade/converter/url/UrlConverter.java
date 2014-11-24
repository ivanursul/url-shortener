package com.optigra.shortener.facade.converter.url;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.optigra.shortener.facade.converter.AbstractConverter;
import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.model.url.ShortUrl;

@Component("urlConverter")
public class UrlConverter extends AbstractConverter<ShortUrl, ShortUrlResource> {

	@Value("${api.output.url}")
	private String shortDomain;
	
	@Override
	public ShortUrlResource convert(final ShortUrl source, final ShortUrlResource target) {
		
		target.setUrl(source.getUrl());
		target.setShortUrl(shortDomain + source.getShortUrl());
		
		return target;
	}

	@Override
	public ShortUrlResource convert(final ShortUrl source) {
		return convert(source, new ShortUrlResource());
	}

	public void setShortDomain(final String shortDomain) {
		this.shortDomain = shortDomain;
	}
	
}
