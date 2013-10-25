package net.lacnic.sisregistro.admin.wicket.util;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public abstract class AcceptActionPanel extends Panel {

	private static final long serialVersionUID = 8182314179766119862L;

	public AcceptActionPanel(String id, String acceptMessage) {
		super(id);
		
		
		add(new Label("acceptMessage", acceptMessage));
		
		add(new Link<Void>("accept") {
			private static final long serialVersionUID = -7885713723609727746L;

			@Override
			public void onClick() {
				try {
					acceptAction();
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		});
	}
	
	public abstract void acceptAction();
}