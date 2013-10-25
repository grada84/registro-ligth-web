package net.lacnic.sisregistro.admin.web.login;

import net.lacnic.sisregistro.admin.web.bases.BasePanel;
import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.protocol.http.WebSession;

public class LogoutPanel extends BasePanel {

	public LogoutPanel(final String id, final Class<? extends WebPage> logoutPage) {
		super(id);

		add(new Label("nombreUsuario", new Model<String>(getUsername())));
		add(new Link("linkLogout") {
			@Override
			public void onClick() {
				SisRegistroManagerSession.get().signOut();
				setResponsePage(logoutPage);
			}
		});
	}

	private String getUsername() {
		return ((SisRegistroManagerSession) WebSession.get()).getNombreUsuarioAutentificado();

	}
}
