package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmGuideline;

public class GuidelineDataModel extends ListDataModel<CrmGuideline> implements
		SelectableDataModel<CrmGuideline>, Serializable {

	private static final long serialVersionUID = 1L;

	public GuidelineDataModel() {
	}

	public GuidelineDataModel(List<CrmGuideline> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmGuideline getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmGuideline> list = (List<CrmGuideline>) getWrappedData();

		for (CrmGuideline row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmGuideline row) {
		return row.getId();
	}
}