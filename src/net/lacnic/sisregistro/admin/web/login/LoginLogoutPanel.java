package net.lacnic.sisregistro.admin.web.login;

import net.lacnic.sisregistro.admin.web.bases.BasePanel;
import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * Panel que despliega login o logout dependiendo si el usuario está logueado o no.
 * 
 * @param id Wicket id
 * @param logoutPage Página a la cual se navega cuando el usuario sale del sistema.
 */
public class LoginLogoutPanel extends BasePanel {

	public LoginLogoutPanel(final String id) {
		this(id, LogoutPage.class);
	}
	
	public LoginLogoutPanel(final String id, final Class<? extends WebPage> logoutPage) {
		super(id);

		Panel panel;
		if (SisRegistroManagerSession.get().isSignedIn()) {
			panel = new LogoutPanel("loginoutPanel", logoutPage);
		} else {
			panel = new LoginPanel("loginoutPanel");
		}
		
		add(panel);
	}
}
