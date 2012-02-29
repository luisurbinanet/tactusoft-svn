package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiWeek;

@Named
public class TablesBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomHibernateDao dao;

	public List<KpiCompany> getListKpiCompany() {
		return dao.find("from KpiCompany o");
	}
	
	public List<KpiCompany> getListKpiCompanyActive() {
		return dao.find("from KpiCompany o where o.state = 1");
	}
	
	public List<KpiDelay> getListKpiDelay() {
		return dao.find("from KpiDelay o");
	}
	
	public List<KpiWeek> getListKpiKpiWeek() {
		return dao.find("from KpiWeek o");
	}
	
	public void save(Object entity){
		dao.persist(entity);
	}
	
	public void remove(Object entity){
		dao.delete(entity);
	}
	
	public BigDecimal getId(String clasz){
		return dao.getId(clasz);
	}

}
