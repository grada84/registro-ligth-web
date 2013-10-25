package net.lacnic.sisregistro.web.app;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.acl.Group;

import javax.security.auth.login.LoginException;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

import org.jboss.security.SimpleGroup;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

public class SisRegistroLoginModule extends UsernamePasswordLoginModule {

	@Override
	protected String getUsersPassword() throws LoginException {
		try {
			String hashPass = "117310c0ff3e9292753bde501bedfb0a".toUpperCase();

//		return Context.getInstance().getAllServiceForRPKIEJB().obtenerClaveSiEsUsuarioHostedConMaestra(getUsername().toUpperCase(), hashPass) ;
		return hashPass;
		} catch (Exception e) {
			throw new LoginException(e.getMessage());
		}
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		Group g = new SimpleGroup("Roles");
		try {
			g.addMember(createIdentity("sisregistro-client"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Group[] { g };
	}
	
	@Override
	protected String createPasswordHash(String user, String pass, String arg2) throws LoginException {
		return wantHashMd5(pass);
	}
	
	private String wantHashMd5(String pass) throws LoginException {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] buffer = pass.getBytes();
			md.update(buffer);
			byte[] digest = md.digest();
			HexBinaryAdapter hex = new HexBinaryAdapter();
			return hex.marshal(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			throw new LoginException(e.getMessage());
		}
	}
}
