package net.lacnic.sisregistro.admin.web;

import net.lacnic.sisregistro.admin.web.bases.PublicBasePage;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * P�gina que se despliega al producirse error 404
 */
public class Error404Page extends PublicBasePage {

	public Error404Page() {
		
		
		add(new BookmarkablePageLink("inicio", Application.get().getHomePage()));
	}

}
