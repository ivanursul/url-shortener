package com.optigra.shortener.model;

/**
 * Interface, that describes all entities.
 * @author ivanursul
 *
 * @param <KEY>
 */
public interface Entity<KEY> {
	
	/**
	 * This method should return key
	 * @return
	 */
	KEY getKey();
}
