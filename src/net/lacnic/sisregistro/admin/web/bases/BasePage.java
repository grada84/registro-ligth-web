package net.lacnic.sisregistro.admin.web.bases;

import java.util.Locale;

import net.lacnic.sisregistro.admin.web.login.LogoutPage;
import net.lacnic.sisregistro.web.app.SisRegistroManagerSession;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;

public class BasePage extends WebPage {

	public BasePage() {
		this(LogoutPage.class);
	}

	public BasePage(final Class<? extends WebPage> logoutPage) {
		super();
		add(new BookmarkablePageLink("home", Application.get().getHomePage()));
		
		Link generateNewLinkES = new Link("lang_es_link") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				SisRegistroManagerSession.get().setLocale(new Locale("ES", "ES"));
			}
		};
		add(generateNewLinkES);
		Link generateNewLinkEN = new Link("lang_en_link") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				SisRegistroManagerSession.get().setLocale(new Locale("EN", "EN"));
			}
		};
		add(generateNewLinkEN);
		Link generateNewLinkPT = new Link("lang_pt_link") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				SisRegistroManagerSession.get().setLocale(new Locale("PT", "PT"));
			}
		};
		add(generateNewLinkPT);
	}

}
