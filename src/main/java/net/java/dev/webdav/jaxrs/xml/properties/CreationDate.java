/*
 * Copyright 2008, 2009, 2012 Markus KARG
 *
 * This file is part of webdav-jaxrs.
 *
 * webdav-jaxrs is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * webdav-jaxrs is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with webdav-jaxrs.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.java.dev.webdav.jaxrs.xml.properties;

import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import net.java.dev.webdav.jaxrs.NullArgumentException;
import net.java.dev.webdav.jaxrs.xml.elements.Rfc3339DateTimeFormat;

/**
 * WebDAV creationdate Property.
 * 
 * @author Markus KARG (mkarg@java.net)
 * 
 * @see <a href="http://www.webdav.org/specs/rfc4918.html#PROPERTY_creationdate">Chapter 15.1 "creationdate Property" of RFC 4918 "HTTP Extensions for Web Distributed Authoring and Versioning (WebDAV)"</a>
 */
@XmlRootElement(name = "creationdate")
public final class CreationDate {

	private Date dateTime;

	/**
	 * Creates an empty (thus <em>invalid</em>) instance. Use <em>only</em> to list property name within response to &lt;propname/&gt; request. Not to be used for creation of valid instances of this property; use {@link #CreationDate(Date)} instead.
	 */
	public CreationDate() {
		// Keeping defaults by intention.
	}

	public CreationDate(final Date dateTime) {
		if (dateTime == null)
			throw new NullArgumentException("dateTime");

		this.dateTime = dateTime;
	}

	public final Date getDateTime() {
		return this.dateTime == null ? null : (Date) this.dateTime.clone();
	}

	@SuppressWarnings("unused")
	@XmlValue
	private final String getXmlDateTime() {
		return this.dateTime == null ? null : new Rfc3339DateTimeFormat().format(this.dateTime);
	}

	@SuppressWarnings("unused")
	private final void setXmlDateTime(final String rfc3339DateTime) throws ParseException {
		this.dateTime = rfc3339DateTime == null ? null : new Rfc3339DateTimeFormat().parse(rfc3339DateTime);
	}

	@Override
	public final boolean equals(final Object other) {
		if (!(other instanceof CreationDate))
			return false;

		final CreationDate that = (CreationDate) other;

		return this.dateTime == null && that.dateTime == null || this.dateTime != null && that.dateTime != null && this.dateTime.equals(that.dateTime);
	}

	@Override
	public final int hashCode() {
		return this.dateTime == null ? 0 : this.dateTime.hashCode();
	}
}
