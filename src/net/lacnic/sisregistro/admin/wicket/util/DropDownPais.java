package net.lacnic.sisregistro.admin.wicket.util;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.model.IModel;

public class DropDownPais extends DropDownChoice<String> {

	private static final long serialVersionUID = 4766509011662393037L;

	public DropDownPais(IModel<String> model) {
		super("pais");
		setChoices(new UtilsPaises().getNombrePaises());
		setModel(model);
		setRequired(true);
	}

}