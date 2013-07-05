package co.com.tactusoft.dialer.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tactusoft.dialer.dao.IDaoCRM;
import co.com.tactusoft.dialer.dao.entities.TblCallOutBoundExt;

@Service
public class ServicesCRMBO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IDaoCRM<?> dao;

	public List<TblCallOutBoundExt> getListCustomer() {
		return dao.getListCustomers();
	}
	
	public void updateCustomer(Long idCallOutBoundExt, Integer idCall) {
		dao.updateCustomer(idCallOutBoundExt, idCall);
	}

}
