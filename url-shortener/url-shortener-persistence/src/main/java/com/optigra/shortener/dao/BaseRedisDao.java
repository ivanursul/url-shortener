package com.optigra.shortener.dao;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.redis.core.RedisTemplate;

import com.optigra.shortener.model.Entity;

@SuppressWarnings("unchecked")
public abstract class BaseRedisDao<ENTITY extends Entity<?>, KEY> implements Dao<ENTITY, KEY> {

	protected RedisTemplate<String, ENTITY> redisTemplate;
	
	protected abstract String getObjetKey();

	@Required
	public void setRedisTemplate(final RedisTemplate<String, ENTITY> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
	
	@Override
	public ENTITY findById(final KEY id) {
		return (ENTITY) redisTemplate.opsForHash().get(getObjetKey(), id);
	}

	@Override
	public KEY save(final ENTITY entity) {
		redisTemplate.opsForHash().put(getObjetKey(), entity.getKey(), entity);
		return (KEY) entity.getKey();
	}

}
