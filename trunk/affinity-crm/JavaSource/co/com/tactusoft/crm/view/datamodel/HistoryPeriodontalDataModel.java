package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOdontologyPeriodontal;

public class HistoryPeriodontalDataModel extends
		ListDataModel<CrmOdontologyPeriodontal> implements
		SelectableDataModel<CrmOdontologyPeriodontal>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryPeriodontalDataModel() {
	}

	public HistoryPeriodontalDataModel(List<CrmOdontologyPeriodontal> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOdontologyPeriodontal getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOdontologyPeriodontal> list = (List<CrmOdontologyPeriodontal>) getWrappedData();

		for (CrmOdontologyPeriodontal row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOdontologyPeriodontal row) {
		return row.getId();
	}
}