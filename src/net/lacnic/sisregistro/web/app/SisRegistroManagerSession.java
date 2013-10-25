package net.lacnic.sisregistro.web.app;

import java.util.ArrayList;
import java.util.List;

import javax.security.jacc.PolicyContextException;

import org.apache.wicket.Request;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.authorization.strategies.role.Roles;
import org.jboss.web.tomcat.security.login.WebAuthentication;

public class SisRegistroManagerSession extends AuthenticatedWebSession {

	private static final long serialVersionUID = 5650965863312480143L;

	private String user;

	public SisRegistroManagerSession(Request request) {
		super(request);
	}

	public void signOut() {
		invalidate();
	}

	@Override
	public boolean authenticate(String username, String password) {
		boolean signedin = false;
		try {
			WebAuthentication wa = new WebAuthentication();
			signedin = wa.login(username, password);
			if (signedin) {
//				user = Context.getInstance().getAllServiceForRPKIEJB().obtenerUserIdIdiomaEmail(username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signedin;

	}

	@Override
	public Roles getRoles() {
		Roles roles = null;
		if (isSignedIn()) {
			try {
				List<String> rr = new ArrayList<String>();
				rr.add("sisregistro-manager");
				roles = addRollesToSession(rr);
			} catch (PolicyContextException e) {
				e.printStackTrace();
			}
		}
		return roles;
	}

	private Roles addRollesToSession(List<String> rolesList) throws PolicyContextException {
		Roles roles = new Roles();
		if (rolesList != null) {
			roles.addAll(rolesList);
		}
		return roles;
	}

	public String getNombreUsuarioAutentificado() {
		return user;
	}

}
