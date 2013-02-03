package co.com.tactusoft.medication.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.medication.dao.IDao;
import co.com.tactusoft.medication.dao.entities.Medication;

@Service
public class ServicesBO {

	@Autowired
	private IDao dao;

	public List<Medication> getListMedication(String doc) {
		return dao.getListMedication(doc);
	}

}
