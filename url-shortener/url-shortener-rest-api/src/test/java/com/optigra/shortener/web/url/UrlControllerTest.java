package com.optigra.shortener.web.url;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.optigra.shortener.facade.resource.url.UrlResource;
import com.optigra.shortener.facade.url.UrlShortenerFacade;

@RunWith(MockitoJUnitRunner.class)
public class UrlControllerTest {

	@InjectMocks
	private UrlController unit;

	@Mock
	private UrlShortenerFacade shortenerFacade;

	private MockMvc mockMvc;

	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp(){
		this.mockMvc = MockMvcBuilders.standaloneSetup(unit).build();
	}

	@Test
	public void testGetUrl() throws Exception{
		// Given
		String param = "someShortUrl";

    	UrlResource expectedResource = new UrlResource();
    	
		// When
    	String expectedResponse = objectMapper.writeValueAsString(expectedResource);
    	when(shortenerFacade.getUrl(any(String.class))).thenReturn(expectedResource);
    	
		// Then
    	mockMvc.perform(get("/url/{shortUrl}", param)
    			.contentType(MediaType.APPLICATION_JSON))
    		.andExpect(status().isOk())
    		.andExpect(content().string(expectedResponse));
    	
    	verify(shortenerFacade).getUrl(param);
	}
	
}
