package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDaily;
import co.com.tactusoft.kpi.model.entities.KpiWeek;

@Service
public class ProcessBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Resource
	private CustomHibernateDao dao;

	public List<KpiWeek> getListKpiKpiWeek40() {
		return dao.find("from KpiWeek o where state = 'En Programa'");
	}

	public List<KpiDaily> getListKpiDailyByWeek(BigDecimal kpiWeek) {
		return dao.find("from KpiDaily o where kpiWeek.id = " + kpiWeek
				+ " order by o.currentDay");
	}
	
	public BigDecimal getId(String clasz){
		return dao.getId(clasz);
	}
	
	public void save(Object entity){
		dao.persist(entity);
	}
}
