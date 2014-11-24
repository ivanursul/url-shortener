package com.optigra.shortener.dao;


/**
 * DAO interface to make CRUD operations with entities.
 * 
 * @author oyats
 *
 * @param <ENTITY>
 *            Entity type.
 * @param <KEY>
 *            Type of Id of entity.
 */
public interface Dao<ENTITY, KEY> {

	/**
	 * Method to find Entity by Id.
	 * 
	 * @param id
	 *            Parameter by which we are trying to find our entity.
	 * @return Found entity.
	 */
	ENTITY findById(KEY id);

	/**
	 * Method for saving entity.
	 * 
	 * @param entity
	 *            Parameter for entity to save.
	 */
	KEY save(ENTITY entity);
}
