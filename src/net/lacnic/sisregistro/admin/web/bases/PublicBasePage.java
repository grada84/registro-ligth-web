package net.lacnic.sisregistro.admin.web.bases;

import org.apache.wicket.markup.html.basic.Label;

/**
 * Página base de la aplicación con autenticación y 
 * métodos auxiliares
 */
public class PublicBasePage extends BasePage {

	public PublicBasePage() {
		

		add(new Label("menu", ""));
	}


}
