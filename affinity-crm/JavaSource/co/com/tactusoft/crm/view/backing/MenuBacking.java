package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmPage;

@Named
@Scope("session")
public class MenuBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	public MenuBacking() {

	}

	public void init(List<CrmPage> listPage) {

	}

}
