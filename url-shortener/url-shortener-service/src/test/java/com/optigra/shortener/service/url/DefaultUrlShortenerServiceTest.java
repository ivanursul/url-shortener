package com.optigra.shortener.service.url;

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

import com.optigra.shortener.dao.Dao;
import com.optigra.shortener.model.url.ShortUrl;
import com.optigra.shortener.model.url.Url;
import com.optigra.shortener.service.generator.UrlGenerator;

@RunWith(MockitoJUnitRunner.class)
public class DefaultUrlShortenerServiceTest {

	@Mock
	private Dao<ShortUrl, String> shortUrlDao;
	
	@Mock
	private UrlGenerator urlGenerator;
	
	@InjectMocks
	private DefaultUrlShortenerService unit;
	
	@Test
	public void testStoreUrl() throws Exception {
		// Given
		String urlLink = "url";
		String shortUrl = "shortUrl";
		Url url = new Url();
		url.setUrl(urlLink);

		ShortUrl expectedUrl = new ShortUrl();
		expectedUrl.setShortUrl(shortUrl);
		expectedUrl.setUrl(urlLink);
		
		// When
		when(urlGenerator.generateShortUrl(any(Url.class))).thenReturn(expectedUrl);
		ShortUrl actualUrl = unit.storeUrl(url);

		// Then
		verify(urlGenerator).generateShortUrl(url);
		verify(shortUrlDao).save(expectedUrl);
		assertEquals(expectedUrl, actualUrl);
	}
	
	@Test
	public void testGetUrl() throws Exception {
		// Given
		String shortUrl = "short Url";

		ShortUrl expectedUrl = new ShortUrl();
		expectedUrl.setShortUrl(shortUrl);
		
		// When
		when(shortUrlDao.findById(anyString())).thenReturn(expectedUrl);
		ShortUrl actualUrl = unit.getUrl(shortUrl);

		// Then
		verify(shortUrlDao).findById(shortUrl);
		assertEquals(expectedUrl, actualUrl);
	}
}
