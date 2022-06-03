/*
 * Copyright 2008, 2009 Daniel MANZKE
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
package org.jugs.webdav.fileserver.grizzly;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.ext.RuntimeDelegate;

import com.sun.grizzly.http.SelectorThread;
import org.jugs.webdav.fileserver.FileServerApplication;
import net.java.dev.webdav.interop.WindowsRedirectorPatchProperty;
import net.java.dev.webdav.interop.grizzly.WindowsRedirectorPatchResourceAdapter;

import com.sun.grizzly.tcp.Adapter;
import com.sun.jersey.api.container.grizzly.GrizzlyServerFactory;

public final class GrizzlyStarter {

	public static void main(final String[] args) throws IOException {
		start(URI.create("http://localhost:80/filesystem"));
	}

	static void start(URI uri) throws IOException {
		FileServerApplication app = new FileServerApplication();
		app.registerEntity(WindowsRedirectorPatchProperty.class);

		System.out.println("Creating Endpoint");
		Adapter adapter = RuntimeDelegate.getInstance().createEndpoint(app, Adapter.class);
		GrizzlyServerFactory.create(uri, new WindowsRedirectorPatchResourceAdapter(adapter));
		System.out.println("Jersey app started: " + uri);
	}

}
