package net.lacnic.sisregistro.admin.wicket.util;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeAction;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
@AuthorizeAction(action = "RENDER", roles = {"certiv6-generic-lacnic"})
public abstract class AcceptAjaxActionPanel extends Panel {

	private static final long serialVersionUID = 8182314179766119862L;

	public AcceptAjaxActionPanel(String id, String acceptMessage) {
		super(id);
		
		
		
		
		AjaxLink<Void> ajaxLink = new AjaxLink<Void>("accept") {
			private static final long serialVersionUID = -7885713723609727746L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				try {
					acceptAction(target);
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}
		};
		add(ajaxLink);
		ajaxLink.add(new Label("acceptMessage", acceptMessage));
	}
	
	public abstract void acceptAction(AjaxRequestTarget target);
}