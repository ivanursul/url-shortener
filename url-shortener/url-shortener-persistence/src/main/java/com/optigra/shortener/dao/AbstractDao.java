package com.optigra.shortener.dao;


/**
 * Abstract class with implemented CRUD methods.
 * 
 * @author ivanursul
 *
 * @param <E>
 *            Type of Entities to manipulate with.
 * @param <T>
 *            Type of ID in our Entity class.
 */
public abstract class AbstractDao<E, T> implements Dao<E, T> {

	
	@Override
	public E findById(final T id) {
		return null;
	}

	@Override
	public void save(final E entity) {
	}
}
