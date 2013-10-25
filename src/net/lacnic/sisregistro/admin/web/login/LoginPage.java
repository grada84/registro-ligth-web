package net.lacnic.sisregistro.admin.web.login;

import net.lacnic.sisregistro.admin.web.bases.PublicBasePage;

import org.apache.wicket.markup.html.WebMarkupContainer;

/**
 * Página de login 
 */
public class LoginPage extends PublicBasePage {

	public LoginPage() {
		LoginPanel loginPanel = new LoginPanel("loginPanel");
		add(loginPanel);
		//ocultar paneles que no disponibles al momento de hacer login
//		add(new WebMarkupContainer("menu").setVisible(false));
		add(new WebMarkupContainer("loginInfo").setVisible(false));
	}
}
