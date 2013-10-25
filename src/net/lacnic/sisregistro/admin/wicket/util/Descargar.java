package net.lacnic.sisregistro.admin.wicket.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.target.resource.ResourceStreamRequestTarget;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.apache.wicket.util.time.Time;

public class Descargar extends WebPage{
	
	public Descargar(final byte[] data,final String name) {
		IResourceStream resourceStream = new IResourceStream() {
			private static final long serialVersionUID = 1L;

			@Override
			public void close() throws IOException {
			}

			@Override
			public String getContentType() {
				return "binary/octet-stream";
			}

			@Override
			public InputStream getInputStream()
					throws ResourceStreamNotFoundException {
				ByteArrayInputStream bais = new ByteArrayInputStream(data);
				return bais;
			}

			private Locale locale;

			@Override
			public Locale getLocale() {
				return locale;
			}

			@Override
			public long length() {
				return data.length;
			}

			@Override
			public void setLocale(Locale l) {
				locale = l;
			}

			@Override
			public Time lastModifiedTime() {
				return Time.valueOf(new Date());
			}
		};

		getRequestCycle().setRequestTarget(
				new ResourceStreamRequestTarget(resourceStream) {
					@Override
					public String getFileName() {
						return (name);
					}
		});
	}

}