package net.lacnic.sisregistro.admin.wicket.util;

import java.io.Serializable;

public class SearchKey implements Serializable{

	private static final long serialVersionUID = 1988220499411139106L;

	private String search;

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearch() {
		return search;
	}
}
