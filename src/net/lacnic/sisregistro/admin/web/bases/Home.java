package net.lacnic.sisregistro.admin.web.bases;

import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;
import net.lacnic.sisregistro.web.micuenta.MiCuenta;

import org.apache.wicket.markup.html.WebMarkupContainer;

/**
 * Página de login
 */
public class Home extends BasePage {

	public Home() {
		if (!SisRegistroManagerSession.get().isSignedIn())
			setResponsePage(MiCuenta.class);

		add(new WebMarkupContainer("menu").setVisible(false));
//		add(new WebMarkupContainer("loginInfo").setVisible(false));
	}
}
