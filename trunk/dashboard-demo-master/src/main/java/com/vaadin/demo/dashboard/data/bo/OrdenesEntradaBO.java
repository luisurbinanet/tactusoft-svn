package com.vaadin.demo.dashboard.data.bo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.demo.dashboard.data.dao.CustomHibernateDao;

@Service
public class OrdenesEntradaBO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private CustomHibernateDao dao;

}
