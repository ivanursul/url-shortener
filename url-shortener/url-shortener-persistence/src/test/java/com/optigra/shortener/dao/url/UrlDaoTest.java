package com.optigra.shortener.dao.url;

import static org.mockito.Mockito.verify;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.optigra.shortener.model.url.ShortUrl;

@RunWith(MockitoJUnitRunner.class)
public class UrlDaoTest {

	@Mock
	private Map<String, ShortUrl> map;
	
	@InjectMocks
	private UrlDao unit;
	
	@Test
	public void testSave() throws Exception {
		// Given
		String url = "url";
		String shortUrl = "short Url";
		ShortUrl entity = new ShortUrl();
		entity.setShortUrl(shortUrl);
		entity.setUrl(url);

		// When
		unit.save(entity);

		// Then
		verify(map).put(shortUrl, entity);
	}
}
