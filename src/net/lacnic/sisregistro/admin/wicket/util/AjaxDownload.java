package net.lacnic.sisregistro.admin.wicket.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Locale;

import org.apache.wicket.Resource;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AbstractAjaxBehavior;
import org.apache.wicket.request.target.resource.ResourceStreamRequestTarget;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.util.resource.ResourceStreamNotFoundException;
import org.apache.wicket.util.time.Time;

public class AjaxDownload extends AbstractAjaxBehavior {
	byte[] file;
	String fileName;

	public AjaxDownload() {
	}

	public AjaxDownload(byte[] file, String fileName) {
		this.file = file;
		this.fileName = fileName;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected String getFileName() {
		return fileName;
	}

	/**
	 * Call this method to initiate the download.
	 */
	public void initiate(AjaxRequestTarget target) {
		CharSequence url = getCallbackUrl();

		target.appendJavascript("window.location.href='" + url + "'");
	}

	public void onRequest() {
		getComponent().getRequestCycle().setRequestTarget(new ResourceStreamRequestTarget(new DescargarResourceStream(file), fileName));
	}

	private class DescargarResourceStream extends Resource implements IResourceStream {

		private static final long serialVersionUID = -8515040328506102940L;
		private Locale locale;
		final byte[] data;

		public DescargarResourceStream(final byte[] pData) {
			this.data = pData;
		}

		@Override
		public IResourceStream getResourceStream() {
			return this;
		}

		@Override
		public void close() throws IOException {
		}

		@Override
		public String getContentType() {
			return "binary/octet-stream";
		}

		@Override
		public InputStream getInputStream() throws ResourceStreamNotFoundException {
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			return bais;
		}

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
	}

}