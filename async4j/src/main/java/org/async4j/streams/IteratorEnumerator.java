/*******************************************************************************
 * Copyright 2013 Async4j Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.async4j.streams;

import java.util.Arrays;
import java.util.Iterator;

import org.async4j.Callback2;

/**
 * {@link Enumerator} implementation that enumerate elements from a synchronous
 * {@link Iterator}
 * 
 * @author Amah AHITE
 * 
 * @param <E>
 */
public class IteratorEnumerator<E> implements Enumerator<E> {
	private final Iterator<E> iterator;

	public IteratorEnumerator(E ... e) {
		this(Arrays.asList(e));
	}

	public IteratorEnumerator(Iterable<E> iterable) {
		this.iterator = iterable.iterator();
	}

	public IteratorEnumerator(Iterator<E> iterator) {
		this.iterator = iterator;
	}

	public void next(Callback2<Boolean, E> k) {
		try {
			boolean b = iterator.hasNext();
			E e = b ? iterator.next() : null;
			k.completed(b, e);
		} catch (Throwable e) {
			k.error(e);
		}
	}

}
