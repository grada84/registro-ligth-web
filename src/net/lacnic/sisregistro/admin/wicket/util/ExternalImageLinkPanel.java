package net.lacnic.sisregistro.admin.wicket.util;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.image.ContextImage;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class ExternalImageLinkPanel extends Panel {

	public ExternalImageLinkPanel(String id, String url, final String title, final String srcImage) {
		super(id);
		ContextImage img = new ContextImage("img", srcImage);
		img.add(new AttributeModifier("title", true, new Model() {
			@Override
			public String getObject() {
				return title;
			}
		}));
		ExternalLink linkRestfulIp = new ExternalLink("link", url);
		linkRestfulIp.add(img);
		add(linkRestfulIp);
	}
}
