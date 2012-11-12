package co.com.tactusoft.crm.model.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class DatesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private DatesIdBean id;

	public DatesBean() {

	}

	@EmbeddedId
	public DatesIdBean getId() {
		return id;
	}

	public void setId(DatesIdBean id) {
		this.id = id;
	}

}
