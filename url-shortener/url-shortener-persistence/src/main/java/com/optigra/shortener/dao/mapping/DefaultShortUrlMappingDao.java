package com.optigra.shortener.dao.mapping;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.optigra.shortener.dao.BaseRedisDao;
import com.optigra.shortener.model.url.Url;

@Repository("redisShortUrlMappingDao")
public class DefaultShortUrlMappingDao extends BaseRedisDao<Url, Long> {
	private static final String INCR_ID = "MAPPING_ID";
	private static final Long DEFAULT_INCR_VALUE = 1L;

	@Resource(name = "defaultRedisTemplate")
	private RedisTemplate<String, Long> defaultRedisTemplate;

	@Value("1")
	private Long delta;
	
	@Override
	protected String getObjetKey() {
		return "UrlMapping";
	}

	@Override
	@Resource(name = "urlMappingRedisTemplate")
	public void setRedisTemplate(final RedisTemplate<String, Url> redisTemplate) {
		super.setRedisTemplate(redisTemplate);
	}

	@Override
	public Long save(final Url entity) {
		Long id = generateIdentifier();
		redisTemplate.opsForHash().put(getObjetKey(), id, entity);
		
		return id;
	}

	/**
	 * TODO: Think about better solution
	 * @return
	 */
	private synchronized Long generateIdentifier() {
		Long id = defaultRedisTemplate.opsForValue().get(INCR_ID);
		defaultRedisTemplate.opsForValue().increment(INCR_ID, delta);
		
		return id;
	}

	@PostConstruct
	public void setup() {
		defaultRedisTemplate.opsForValue().set(INCR_ID, DEFAULT_INCR_VALUE);
	}
}
