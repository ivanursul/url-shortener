package com.optigra.shortener.facade.converter.url;

import org.springframework.stereotype.Component;

import com.optigra.shortener.facade.converter.AbstractConverter;
import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.model.url.Url;

@Component("urlResourceConverter")
public class UrlResourceConverter extends AbstractConverter<UrlResource, Url> {

	@Override
	public Url convert(final UrlResource source, final Url target) {
		
		target.setUrl(source.getUrl());
		
		return target;
	}

	@Override
	public Url convert(final UrlResource source) {
		return convert(source, new Url());
	}

}
