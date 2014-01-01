/*
 * #%L
 * WebDAV Support for JAX-RS
 * %%
 * Copyright (C) 2008 - 2014 The java.net WebDAV Project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package net.java.dev.webdav.jaxrs.xml.elements;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

import net.java.dev.webdav.jaxrs.NullArgumentException;

/**
 * WebDAV error XML Element.
 * 
 * @author Markus KARG (mkarg@java.net)
 * 
 * @see <a href="http://www.webdav.org/specs/rfc4918.html#ELEMENT_error">Chapter 14.5 "error XML Element" of RFC 4918
 *      "HTTP Extensions for Web Distributed Authoring and Versioning (WebDAV)"</a>
 */
@XmlRootElement
public final class Error {

	@XmlAnyElement(lax = true)
	public LinkedList<Object> errors;

	@SuppressWarnings("unused")
	private Error() {
		this.errors = new LinkedList<Object>();
	}

	public Error(final Object error, final Object... errors) {
		if (error == null)
			throw new NullArgumentException("error");

		this.errors = new LinkedList<Object>(singletonList(error));
		this.errors.addAll(asList(errors));
	}

	@SuppressWarnings("unchecked")
	public final List<Object> getErrors() {
		return (List<Object>) this.errors.clone();
	}

	@Override
	public final int hashCode() {
		return this.errors.hashCode();
	}

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof Error))
			return false;

		final Error that = (Error) other;

		return this.errors.equals(that.errors);
	}
}
