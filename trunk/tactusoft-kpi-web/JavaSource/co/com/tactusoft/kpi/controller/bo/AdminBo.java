package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDailyDelay;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiHeader;
import co.com.tactusoft.kpi.model.entities.KpiHeaderDelay;

@Named
public class AdminBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CustomHibernateDao dao;

	public AdminBo() {

	}

	public List<KpiHeader> getListKpiHeader() {
		return dao.find("from KpiHeader o");
	}

	public List<KpiHeader> getListKpiHeaderByCompany(BigDecimal idCompany) {
		return dao
				.find("from KpiHeader o where o.kpiCompany.id = " + idCompany);
	}

	public List<KpiHeaderDelay> getListKpiConfigByHeader(BigDecimal idHeader) {
		return dao.find("from KpiHeaderDelay o where o.kpiHeader.id = "
				+ idHeader + " order by o.kpiDelay.korder");
	}

	public List<KpiDelay> getListKpiDelayByHeader(BigDecimal idHeader) {
		return dao
				.find("select o.kpiDelay from KpiHeaderDelay o where o.kpiHeader.id = "
						+ idHeader + " order by o.kpiDelay.korder");
	}

	public List<KpiDailyDelay> getListKpiDailyDelayByDay(BigDecimal idDay) {
		return dao.find("from KpiDailyDelay o where o.kpiDaily.id = " + idDay);
	}

	public void save(Object entity) {
		dao.persist(entity);
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

}
