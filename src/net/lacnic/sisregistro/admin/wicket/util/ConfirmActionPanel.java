package net.lacnic.sisregistro.admin.wicket.util;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

public abstract class ConfirmActionPanel extends Panel {

	private static final long serialVersionUID = 8182314179766119862L;
	private AjaxLink<Void> ajaxLinkYes;
	private AjaxLink<Void> ajaxLinkNo;
	private String confirmationMessage;

	public ConfirmActionPanel(String id, String confirmationMessage) {
		this(id, confirmationMessage, true);
	}

	public ConfirmActionPanel(String id, String confirmationMessage, boolean mostraNO) {
		super(id);
		this.confirmationMessage = confirmationMessage;
		Form form = new Form("aux");
		add(form);
		form.add(new Label("message", new PropertyModel(ConfirmActionPanel.this, "confirmationMessage")));

		ajaxLinkYes = new AjaxLink<Void>("yes") {

			private static final long serialVersionUID = -2279565427577734595L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				confirmAction(target);
			}
		};
		form.add(ajaxLinkYes);

		ajaxLinkNo = new AjaxLink<Void>("no") {

			private static final long serialVersionUID = 3102106112794933173L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				cancelAction(target);
			}
		};
		form.add(ajaxLinkNo);
		ajaxLinkNo.setVisible(mostraNO);
	}

	public abstract void confirmAction(AjaxRequestTarget target);

	public abstract void cancelAction(AjaxRequestTarget target);

	public abstract void returnAction(AjaxRequestTarget target);

	public String getConfirmationMessage() {
		return confirmationMessage;
	}

	public void setConfirmationMessage(String confirmationMessage) {
		this.confirmationMessage = confirmationMessage;
	}
}