package net.lacnic.sisregistro.web.organizaciones;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.lacnic.domain.mysql.Entidad;
import net.lacnic.sisregistro.admin.web.bases.BasePage;
import net.lacnic.sisregistro.admin.web.bases.RegistroBasePage;

import org.apache.wicket.markup.html.basic.Label;

public class DetalleOrganizacion extends RegistroBasePage {

	public DetalleOrganizacion() {
		super();
		try {
			Entidad a = new Entidad();
			a.setDataRenovacao(new Date());
			a.setEndPais("UY");
			a.setIdDocumento("UY-ANTA-LACNIC");
			a.setNome("Antel papei");
			a.setDataCadastro(new Date());
			add(new Label("nombre",a.getNome()));
			add(new Label("pais", a.getEndPais()));
			add(new Label("orgId", a.getIdDocumento()));
			add(new Label("dataRenovacion", new SimpleDateFormat("dd/MM/yyyy").format(a.getDataRenovacao())));
			add(new Label("dataAniversario", new SimpleDateFormat("dd/MM/yyyy").format(a.getDataCadastro())));
//			final ListEleccionesPanel listEleccionesPanel = new ListEleccionesPanel("listaEleccionesPanel");
//			add(listEleccionesPanel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public MiCuenta(PageParameters params) {
//		super();
//		try {
//			List<EleccionData> elecciones = new ArrayList<EleccionData>();
//
//			if (UtilsParameters.isAbiertas(params)) {
//				elecciones = Context.getInstance().getManagerBeanRemote().obtenerEleccionesAbiertas();
//			} else if (UtilsParameters.isCerradas(params)) {
//				elecciones = Context.getInstance().getManagerBeanRemote().obtenerEleccionesCerradas();
//			} else if (UtilsParameters.isNuevas(params)) {
//				elecciones = Context.getInstance().getManagerBeanRemote().obtenerEleccionesNuevas();
//			} else {
//				elecciones = Context.getInstance().getManagerBeanRemote().obtenerEleccionesLight();
//			}
//			final ListEleccionesPanel listEleccionesPanel = new ListEleccionesPanel("listaEleccionesPanel", elecciones);
//			add(listEleccionesPanel);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}