package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiGroup;
import co.com.tactusoft.kpi.model.entities.KpiWeek;
import co.com.tactusoft.kpi.model.entities.KpiWorkOrder;

@Service
public class TablesBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CustomHibernateDao dao;

	public List<KpiGroup> getListKpiGroup() {
		return dao.find("from KpiGroup o");
	}
	
	public List<KpiWorkOrder> getListKpiWorkOrder() {
		return dao.find("from KpiWorkOrder o");
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
