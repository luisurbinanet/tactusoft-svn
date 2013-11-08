package co.com.tactusoft.crm.postsale.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.crm.model.dao.sap.SapCustomHibernateDao;
import co.com.tactusoft.crm.model.entities.sap.SapMedication;

@Service
public class SapBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private SapCustomHibernateDao dao;

	public List<SapMedication> getListSAPMedication(String dateString) {
		return dao.findNamedQuery("SapMedication.findByDateBill");
	}
}
