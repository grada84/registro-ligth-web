package net.lacnic.sisregistro.admin.wicket.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;


public class FormatUtils {
	
	public static String hashMD5(String pass) {
		String r = null;

		try {
			byte[] textBytes = pass.getBytes();
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(textBytes);
			byte[] hash = md.digest();
			HexBinaryAdapter hex = new HexBinaryAdapter();
			r = hex.marshal(hash);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return r;
	}
	
}
