package org.sfm.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of {@link RowHandler} that collect all the value into a list.<p>
 * Equivalent to a {@link java.util.stream.Collectors#toList()}.
 * @param <T> the type of the callback argument
 */
public final class ImmutableListCollectorHandler<T> implements RowHandler<T> {

	private final List<T> list = new ArrayList<T>();
	
	@Override
	public void handle(final T t) {
		list.add(t);
	}

    /**
     *
     * @return the collected objects
     */
	public List<T> getList() {
		return Collections.unmodifiableList(list);
	}
}
