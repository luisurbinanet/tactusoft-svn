package com.tacticlogistics.model.bo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tacticlogistics.model.dao.CustomHibernateDao;
import com.tacticlogistics.model.entities.Ciudad;
import com.tacticlogistics.model.entities.Pais;

@Service
public class OrdenesEntradaBO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomHibernateDao dao;

	public List<Pais> getListPaises() {
		return dao.find("from Pais");
	}

	public List<Ciudad> getListCiudades(Integer idPais) {
		return dao.find("from Ciudad o where o.pais.id = " + idPais);
	}

}
