package com.optigra.shortener.facade.converter.url;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.model.url.ShortUrl;

public class UrlConverterTest {

	private String shortDomain = "shortUrl";
	
	private UrlConverter unit = new UrlConverter();

	@Before
	public void setup() {
		unit.setShortDomain(shortDomain);
	}
	
	@Test
	public void testConvert() throws Exception {
		// Given
		String url = "url";
		String shortUrl = "shorturl";
		ShortUrl source = new ShortUrl();
		source.setUrl(url);
		source.setShortUrl(shortUrl);
		
		ShortUrlResource expectedUrl = new ShortUrlResource();
		expectedUrl.setShortUrl(shortDomain + shortUrl);
		expectedUrl.setUrl(url);
		
		// When
		ShortUrlResource actualUrl = unit.convert(source);

		// Then
		assertEquals(expectedUrl, actualUrl);
	}
}
