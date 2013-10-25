package net.lacnic.sisregistro.web.app;

import net.lacnic.sisregistro.admin.web.AccesoDenegadoPage;
import net.lacnic.sisregistro.admin.web.bases.Home;
import net.lacnic.sisregistro.admin.web.login.LoginPage;
import net.lacnic.sisregistro.admin.web.login.LogoutPage;
import net.lacnic.sisregistro.web.micuenta.MiCuenta;

import org.apache.wicket.Page;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.settings.IExceptionSettings;

public class SisRegistroManagerApp extends AuthenticatedWebApplication {

	@Override
	protected void init() {
		super.init();

		mountBookmarkablePage("/login", LoginPage.class);
		mountBookmarkablePage("/logout", LogoutPage.class);
		mountBookmarkablePage("/home", Home.class);
		mountBookmarkablePage("/accessdenied", AccesoDenegadoPage.class);
		mountBookmarkablePage("/myaccount", MiCuenta.class);
		

		getApplicationSettings().setPageExpiredErrorPage(AccesoDenegadoPage.class);
		getApplicationSettings().setAccessDeniedPage(AccesoDenegadoPage.class);
		getExceptionSettings().setUnexpectedExceptionDisplay(IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return MiCuenta.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginPage.class;
	}

	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		return SisRegistroManagerSession.class;
	}

}