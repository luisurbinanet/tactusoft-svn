package co.com.tactusoft.medication.backing;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medication.bo.ServicesBO;
import co.com.tactusoft.medication.dao.entities.Medication;

@Named
@Scope("session")
public class Backing {
	
	@Inject
	private ServicesBO servicesBO; 
	
	private List<Medication> list;

	public List<Medication> getList() {
		list = servicesBO.getListMedication("24160836");
		return list;
	}

	public void setList(List<Medication> list) {
		this.list = list;
	}

}
