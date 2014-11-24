package com.optigra.shortener.facade.converter.url;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.model.url.Url;

public class UrlResourceConverterTest {

	private UrlResourceConverter unit = new UrlResourceConverter();
	
	@Test
	public void testConvert() throws Exception {
		// Given
		String url = "urls";
		UrlResource source = new UrlResource();
		source.setUrl(url);

		Url expectedUrl = new Url();
		expectedUrl.setUrl(url);
		
		// When
		Url actualUrl = unit.convert(source);

		// Then
		assertEquals(expectedUrl, actualUrl);
	}
}
