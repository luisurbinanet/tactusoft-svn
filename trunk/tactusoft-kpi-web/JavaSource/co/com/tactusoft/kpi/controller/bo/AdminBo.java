package co.com.tactusoft.kpi.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.com.tactusoft.kpi.model.dao.CustomHibernateDao;
import co.com.tactusoft.kpi.model.entities.KpiDelay;
import co.com.tactusoft.kpi.model.entities.KpiHeader;
import co.com.tactusoft.kpi.model.entities.KpiHeaderDelay;

@Service
@Scope("singleton")
public class AdminBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
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

	public void save(Object entity) {
		dao.persist(entity);
	}

	public void remove(Object entity) {
		dao.delete(entity);
	}

}
