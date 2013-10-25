package net.lacnic.sisregistro.web.organizaciones;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.lacnic.domain.mysql.Entidad;
import net.lacnic.sisregistro.admin.web.bases.RegistroBasePage;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class ListOrganizaciones extends RegistroBasePage {

	public ListOrganizaciones() {
		super();

		try {
			List<Entidad> entidades = new ArrayList<Entidad>();
			Entidad a = new Entidad();
			a.setDataRenovacao(new Date());
			a.setEndPais("UY");
			a.setIdDocumento("UY-ANTA-LACNIC");
			a.setNome("Antel papei");
			a.setDataCadastro(new Date());
			Entidad b = new Entidad();
			b.setDataRenovacao(new Date());
			b.setEndPais("UY");
			b.setIdDocumento("UY-ANTA-LACNIC");
			b.setNome("Antel papei");
			b.setDataCadastro(new Date());
			Entidad c = new Entidad();
			c.setDataRenovacao(new Date());
			c.setEndPais("UY");
			c.setIdDocumento("UY-ANTA-LACNIC");
			c.setNome("Antel papei");
			c.setDataCadastro(new Date());
			entidades.add(a);
			entidades.add(b);
			entidades.add(c);
			final WebMarkupContainer contenedorListaOrganizaciones = new WebMarkupContainer("contenedorListaOrganizaciones");
			contenedorListaOrganizaciones.setOutputMarkupPlaceholderTag(true);
			final ListView<Entidad> dataViewOrgs = new ListView<Entidad>("dataViewOrganizaciones", entidades) {
				private static final long serialVersionUID = 1786359392545666490L;

				@Override
				protected void populateItem(ListItem item) {
					final Entidad actual = (Entidad) item.getModelObject();

					item.add(new Label("nombre", actual.getNome()));
					item.add(new Label("dataRenovacao", new SimpleDateFormat("dd/MM/yyyy").format(actual.getDataRenovacao())));
					item.add(new Label("dataCadastro", new SimpleDateFormat("dd/MM/yyyy").format(actual.getDataCadastro())));
					item.add(new Label("orgId", actual.getIdDocumento()));
					item.add(new Label("pais", actual.getEndPais()));
					item.add(new Link("linkDetalleOrganizacion") {

						@Override
						public void onClick() {
							setResponsePage(DetalleOrganizacion.class);
						}
					});
				}
			};
			contenedorListaOrganizaciones.add(dataViewOrgs);
			add(contenedorListaOrganizaciones);

			List<Entidad> entidadesnomiembro = new ArrayList<Entidad>();
			Entidad d = new Entidad();
			d.setDataRenovacao(new Date());
			d.setEndPais("UY");
			d.setIdDocumento("UY-ANTA-LACNIC");
			d.setNome("Antel papei no miembro");
			d.setDataCadastro(new Date());
			Entidad e = new Entidad();
			e.setDataRenovacao(new Date());
			e.setEndPais("UY");
			e.setIdDocumento("UY-ANTA-LACNIC");
			e.setNome("Antel papei no miembro");
			e.setDataCadastro(new Date());
			Entidad f = new Entidad();
			f.setDataRenovacao(new Date());
			f.setEndPais("UY");
			f.setIdDocumento("UY-ANTA-LACNIC");
			f.setNome("Antel papei no miembro");
			f.setDataCadastro(new Date());
			entidadesnomiembro.add(d);
			entidadesnomiembro.add(e);
			entidadesnomiembro.add(f);
			final WebMarkupContainer contenedorListaOrganizacionesNoMiembro = new WebMarkupContainer("contenedorListaOrganizacionesNoMiembro");
			contenedorListaOrganizaciones.setOutputMarkupPlaceholderTag(true);
			final ListView<Entidad> dataViewOrgsNoMiembro = new ListView<Entidad>("dataViewOrganizacionesNoMiembro", entidadesnomiembro) {
				private static final long serialVersionUID = 1786359392545666490L;

				@Override
				protected void populateItem(ListItem item) {
					final Entidad actual = (Entidad) item.getModelObject();

					item.add(new Label("nombre", actual.getNome()));
					item.add(new Label("dataRenovacao", new SimpleDateFormat("dd/MM/yyyy").format(actual.getDataRenovacao())));
					item.add(new Label("dataCadastro", new SimpleDateFormat("dd/MM/yyyy").format(actual.getDataCadastro())));
					item.add(new Label("orgId", actual.getIdDocumento()));
					item.add(new Label("pais", actual.getEndPais()));
					item.add(new Link("linkDetalleOrganizacion") {

						@Override
						public void onClick() {
							setResponsePage(DetalleOrganizacion.class);
						}
					});
				}
			};
			contenedorListaOrganizacionesNoMiembro.add(dataViewOrgsNoMiembro);
			add(contenedorListaOrganizacionesNoMiembro);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// public ListIpsInhabilitadas(PageParameters params) {
	// super();
	// try {
	// List<EleccionData> elecciones;
	//
	// if(UtilsParameters.isAbiertas(params))
	// {
	// elecciones =
	// Context.getInstance().getManagerBeanRemote().obtenerEleccionesAbiertas();
	// }
	// else if(UtilsParameters.isCerradas(params)){
	// elecciones =
	// Context.getInstance().getManagerBeanRemote().obtenerEleccionesCerradas();
	// }
	// else if(UtilsParameters.isNuevas(params)){
	// elecciones =
	// Context.getInstance().getManagerBeanRemote().obtenerEleccionesNuevas();
	// }
	// else
	// {
	// elecciones =
	// Context.getInstance().getManagerBeanRemote().obtenerElecciones();
	// }
	// final ListEleccionesPanel listEleccionesPanel = new
	// ListEleccionesPanel("listaEleccionesPanel", elecciones);
	// listEleccionesPanel.setOutputMarkupId(true);
	// add(listEleccionesPanel);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}