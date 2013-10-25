package net.lacnic.sisregistro.admin.web.bases;

import net.lacnic.sisregistro.admin.web.login.LoginPage;
import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;
import net.lacnic.sisregistro.web.micuenta.MiCuenta;
import net.lacnic.sisregistro.web.organizaciones.ListOrganizaciones;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

/**
 * Menu de la aplicaci�n
 */
public class MenuPanel extends BasePanel {
	public MenuPanel(String id) {
		super(id);

		add(new BookmarkablePageLink("miCuenta", MiCuenta.class));
		add(new BookmarkablePageLink("organizaciones", ListOrganizaciones.class));
		add(new BookmarkablePageLink("recursos", MiCuenta.class));
//		add(new BookmarkablePageLink("cerradas", MiCuenta.class));

//		add(new BookmarkablePageLink("nuevaEleccion", NuevaEleccion.class));
//		add(new BookmarkablePageLink("directorio", NuevaEleccion.class, UtilsParameters.getFilterDirectorio()));
//		add(new BookmarkablePageLink("aso", NuevaEleccion.class, UtilsParameters.getFilterAso()));
//		add(new BookmarkablePageLink("fiscal", NuevaEleccion.class, UtilsParameters.getFilterFiscal()));
//		add(new BookmarkablePageLink("electoral", NuevaEleccion.class, UtilsParameters.getFilterElectoral()));
//		add(new BookmarkablePageLink("moderador", NuevaEleccion.class, UtilsParameters.getFilterModerador()));
//
//		add(new BookmarkablePageLink("gestionIps", ListIpsInhabilitadas.class));
//		add(new BookmarkablePageLink("gestionTokens", ListTokenBaneados.class));
//
//		add(new BookmarkablePageLink("gestionComisionados", GestionComisionados.class));
		add(new Link("logout") {

			@Override
			public void onClick() {
				SisRegistroManagerSession.get().clear();
				SisRegistroManagerSession.get().invalidate();
				SisRegistroManagerSession.get().invalidateNow();
				SisRegistroManagerSession.get().signOut();
				setResponsePage(LoginPage.class);
			}

		});

	}

}
