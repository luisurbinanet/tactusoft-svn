package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmHistoryHistory;

public class HistoryHistoryDataModel extends ListDataModel<CrmHistoryHistory> implements
		SelectableDataModel<CrmHistoryHistory>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryHistoryDataModel() {
	}

	public HistoryHistoryDataModel(List<CrmHistoryHistory> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmHistoryHistory getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmHistoryHistory> list = (List<CrmHistoryHistory>) getWrappedData();

		for (CrmHistoryHistory row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmHistoryHistory row) {
		return row.getId();
	}
}