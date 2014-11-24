package com.optigra.shortener.facade.url;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.optigra.shortener.facade.converter.Converter;
import com.optigra.shortener.facade.resource.url.ShortUrlResource;
import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;
import com.optigra.shortener.service.url.UrlShortenerService;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUrlShortenerFacadeTest {

	@Mock
	private Converter<UrlResource, Url> urlResourceConverter;
	
	@Mock
	private Converter<ShortUrl, ShortUrlResource> urlConverter;
	
	@Mock
	private UrlShortenerService urlShortenerService;
	
	@InjectMocks
	private DefaultUrlShortenerFacade unit;
	
	@Test
	public void testStoreUrl() throws Exception {
		// Given
		String shortUrlLink = "short URl";
		String urlLink = "url";
		
		Url url = new Url();
		url.setUrl(urlLink);
		
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setUrl(urlLink);
		
		UrlResource resource = new UrlResource();
		resource.setUrl(urlLink);

		ShortUrlResource expectedUrl = new ShortUrlResource();
		expectedUrl.setShortUrl(shortUrlLink);
		expectedUrl.setUrl(urlLink);
		
		// When
		when(urlResourceConverter.convert(any(UrlResource.class))).thenReturn(url);
		when(urlShortenerService.storeUrl(any(Url.class))).thenReturn(shortUrl);
		when(urlConverter.convert(any(ShortUrl.class))).thenReturn(expectedUrl);
		
		UrlResource actualUrl = unit.storeUrl(resource);

		// Then
		verify(urlResourceConverter).convert(resource);
		verify(urlShortenerService).storeUrl(url);
		verify(urlConverter).convert(shortUrl);
		
		assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	public void testGetUrl() throws Exception {
		// Given
		String shortUrlLink = "shortUrl";
		String url = "url";

		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setUrl(url);
		
		ShortUrlResource expectedUrl = new ShortUrlResource();
		expectedUrl.setShortUrl(shortUrlLink);
		expectedUrl.setUrl(url);
		
		// When
		when(urlShortenerService.getUrl(anyString())).thenReturn(shortUrl);
		when(urlConverter.convert(any(ShortUrl.class))).thenReturn(expectedUrl);
		UrlResource actualUrl = unit.getUrl(shortUrlLink);

		// Then
		verify(urlShortenerService).getUrl(shortUrlLink);
		verify(urlConverter).convert(shortUrl);
		assertEquals(expectedUrl, actualUrl);
	}
}
