package com.optigra.shortener.dao;

import java.util.HashMap;
import java.util.Map;


/**
 * Abstract class with implemented CRUD methods.
 * 
 * @author ivanursul
 *
 * @param <ENTITY>
 *            Type of Entities to manipulate with.
 * @param <KEY>
 *            Type of ID in our Entity class.
 */
public abstract class AbstractDao<ENTITY, KEY> implements Dao<ENTITY, KEY> {

	private Map<KEY, ENTITY> map = new HashMap<KEY, ENTITY>();
	
	@Override
	public ENTITY findById(final KEY id) {
		return map.get(id);
	}

	public Map<KEY, ENTITY> getMap() {
		return map;
	}

}
