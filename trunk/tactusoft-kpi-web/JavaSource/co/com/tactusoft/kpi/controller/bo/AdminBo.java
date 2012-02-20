package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiCompany;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiWeek;

@Service
public class AdminBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CustomHibernateDao dao;

	public AdminBo() {

	}

	public List<KpiCompany> getListKpiCompany() {
		return dao.find("from KpiCompany o");
	}

	public List<KpiDelay> getListKpiDelay() {
		return dao.find("from KpiDelay o");
	}

	public List<KpiWeek> getListKpiKpiWeek() {
		return dao.find("from KpiWeek o");
	}

	public void save(Object entity) {
		dao.persist(entity);
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

	public BigDecimal getId(String clasz) {
		return dao.getId(clasz);
	}

}
