package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCaseStudy;

public class CaseStudyDataModel extends ListDataModel<CrmCaseStudy> implements
		SelectableDataModel<CrmCaseStudy>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseStudyDataModel() {
	}

	public CaseStudyDataModel(List<CrmCaseStudy> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCaseStudy getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCaseStudy> list = (List<CrmCaseStudy>) getWrappedData();

		for (CrmCaseStudy row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCaseStudy car) {
		return car.getId();
	}
}