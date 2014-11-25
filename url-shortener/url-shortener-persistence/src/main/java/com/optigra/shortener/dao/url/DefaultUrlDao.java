package com.optigra.shortener.dao.url;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.optigra.shortener.dao.BaseRedisDao;
import com.optigra.shortener.model.url.ShortUrl;

@Repository("redisUrlDao")
public class DefaultUrlDao extends BaseRedisDao<ShortUrl, String> {

	@Override
	protected String getObjetKey() {
		return "User";
	}

	@Override
	@Resource(name = "redisShortUrlTemplate")
	public void setRedisTemplate(final RedisTemplate<String, ShortUrl> redisTemplate) {
		super.setRedisTemplate(redisTemplate);
	}

}
