package co.com.tactusoft.crm.controller.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import co.com.tactusoft.crm.model.dao.CustomHibernateDao;
import co.com.tactusoft.crm.model.entities.CrmCall;
import co.com.tactusoft.crm.model.entities.CrmCallType;
import co.com.tactusoft.crm.model.entities.CrmCallTypeDetail;
import co.com.tactusoft.crm.model.entities.CrmCampaign;
import co.com.tactusoft.crm.model.entities.CrmGuideline;
import co.com.tactusoft.crm.model.entities.CrmPatient;
import co.com.tactusoft.crm.util.Constant;
import co.com.tactusoft.crm.util.FacesUtil;

@Named
public class CapaignBo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CustomHibernateDao dao;

	public CrmGuideline getGuideline(String campaignId) {
		List<CrmGuideline> list = dao
				.find("FROM CrmGuideline o WHERE o.phone = '" + campaignId
						+ "'");
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public List<CrmPatient> getListPatient(String phone) {
		return dao.find("FROM CrmPatient o WHERE o.phoneNumber = '" + phone
				+ "' OR o.cellNumber = '" + phone + "'");
	}

	public List<CrmCallType> getListCallType(String type) {
		return dao.find("from CrmCallType where callType = '" + type + "'");
	}

	public List<CrmCallTypeDetail> getListCallTypeDetail(Integer idCallType) {
		return dao.find("from CrmCallTypeDetail where crmCallType.id = '"
				+ idCallType + "'");
	}

	public List<CrmCallType> getListCallTypeIncoming() {
		return getListCallType(Constant.CALLED_TYPE_IN);
	}

	public List<CrmCallType> getListCallTypeOutcoming() {
		return getListCallType(Constant.CALLED_TYPE_OUT);
	}

	public CrmCall getListCallById(BigDecimal id) {
		return (CrmCall) dao.find("from CrmCall where idCall = " + id).get(0);
	}

	public CrmCampaign getCampaignByPatientAndDate(BigDecimal idPatient,
			Date date) {
		String dateString = FacesUtil.formatDate(date, "yyyy-MM-dd");
		CrmCampaign result = new CrmCampaign();
		List<CrmCampaign> list = dao
				.find("from CrmCampaign o where Date(o.dateCall) = '"
						+ dateString + "' AND o.crmPatient.id = " + idPatient);
		if (!list.isEmpty()) {
			result = list.get(0);
		}
		return result;
	}

	public int saveCall(CrmCall entity) {
		if (entity.getId() == null) {
			entity.setId(getId(CrmCall.class));
		}
		return this.persist(entity);
	}

	public <T> BigDecimal getId(Class<T> clasz) {
		return dao.getId(clasz);
	}

	public int persist(Object entity) {
		int result = 0;
		try {
			result = dao.persist(entity);
		} catch (RuntimeException ex) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				result = -1;
			} else if (ex.getCause() instanceof DataIntegrityViolationException) {
				result = -2;
			}
		}
		return result;
	}

}
