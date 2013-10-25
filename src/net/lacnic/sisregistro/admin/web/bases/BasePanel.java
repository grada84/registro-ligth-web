package net.lacnic.sisregistro.admin.web.bases;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

public class BasePanel extends Panel {
//	protected Logger log;
		
	public BasePanel(String id) {
		super(id);
//		log = Logger.getLogger(this.getClass());
	}

	public BasePanel(String id, IModel<?> model) {
		super(id, model);
	}

}
