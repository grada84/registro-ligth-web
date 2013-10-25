package net.lacnic.sisregistro.web.app;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.lacnic.ejb.service.UsuarioServiceEJB;

public class Context {

	private static String JBOSSCONFURI = System.getProperty("jboss.server.config.url").substring(5);
	private static String JBOSSTEMPURI = System.getProperty("jboss.server.temp.dir");

	
	private static Context instance;
	private InitialContext ctxHosted;

	private static UsuarioServiceEJB usuarioServiceEJB;

	private Context() {
		try {

			ctxHosted = new InitialContext();
			
			setUsuarioServiceEJB((UsuarioServiceEJB) ctxHosted.lookup("UsuarioServiceEJBBean/remote"));

		} catch (NamingException ex) {
			Logger.getLogger(Context.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		return instance;
	}

	public static String getJbossConfUri() {
		return JBOSSCONFURI;
	}

	public static String getJbossTempUri() {
		return JBOSSTEMPURI.concat("/");
	}

	public static UsuarioServiceEJB getUsuarioServiceEJB() {
		return usuarioServiceEJB;
	}

	public static void setUsuarioServiceEJB(UsuarioServiceEJB usuarioServiceEJB) {
		Context.usuarioServiceEJB = usuarioServiceEJB;
	}

	
}
