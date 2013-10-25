package net.lacnic.sisregistro.admin.web.bases;

import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;

import org.apache.wicket.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.protocol.http.WebSession;

/**
 * P�gina base de la aplicaci�n con autenticaci�n y 
 * m�todos auxiliares
 */
@AuthorizeInstantiation("sisregistro-manager")
public class RegistroBasePage extends BasePage {

	public RegistroBasePage() {
		super();

		MenuPanel menuPanel = new MenuPanel("menu");
		
		add(menuPanel);
	}
	/**
	 * Obtiene el usuario actual en la sesi�n
	 * @return
	 */
	public String getCurrentUser() {
		SisRegistroManagerSession session = (SisRegistroManagerSession) WebSession.get();
		return session.getNombreUsuarioAutentificado();
	}

}
