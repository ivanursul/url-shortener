package com.optigra.shortener.dao;


/**
 * DAO interface to make CRUD operations with entities.
 * 
 * @author oyats
 *
 * @param <E>
 *            Entity type.
 * @param <T>
 *            Type of Id of entity.
 */
public interface Dao<E, T> {

	/**
	 * Method to find Entity by Id.
	 * 
	 * @param id
	 *            Parameter by which we are trying to find our entity.
	 * @return Found entity.
	 */
	E findById(T id);

	/**
	 * Method for saving entity.
	 * 
	 * @param entity
	 *            Parameter for entity to save.
	 */
	void save(E entity);
}
