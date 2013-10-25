package net.lacnic.sisregistro.web.micuenta;

import net.lacnic.sisregistro.admin.web.bases.RegistroBasePage;

import org.apache.wicket.markup.html.basic.Label;

public class MiCuenta extends RegistroBasePage {

	public MiCuenta() {
		super();
		try {
			add(new Label("nombre", "Nicolás Fiumarelli"));
			add(new Label("email", "nicocamarao@gmail.com"));
			add(new Label("telefono", "094120967"));
			add(new Label("direccion", "Mi direccción"));
			add(new Label("pais", "UY"));
			add(new Label("fechaMembresia", "17/08/2011"));
			add(new Label("fechaUltAsignacion", "17/09/2013"));
			add(new Label("idioma", "SP"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}