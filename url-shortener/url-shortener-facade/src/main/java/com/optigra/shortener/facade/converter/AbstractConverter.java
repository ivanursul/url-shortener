package com.optigra.shortener.facade.converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract convert class.
 * 
 * @author rostyslav
 *
 * @param <SOURCE>
 *            Source to convert.
 * @param <TARGET>
 *            Result of converting.
 */
public abstract class AbstractConverter<SOURCE, TARGET> implements Converter<SOURCE, TARGET> {

	@Override
	public List<TARGET> convertAll(final List<SOURCE> sources) {

		return convertAll(sources, new ArrayList<TARGET>(sources.size()));
	}

	@Override
	public List<TARGET> convertAll(final List<SOURCE> sources, final List<TARGET> targets) {

		for (SOURCE source : sources) {
			targets.add(convert(source));
		}

		return targets;
	}
}
