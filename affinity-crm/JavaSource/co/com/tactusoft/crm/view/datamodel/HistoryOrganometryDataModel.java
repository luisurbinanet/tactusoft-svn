package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmHistoryOrganometry;

public class HistoryOrganometryDataModel extends ListDataModel<CrmHistoryOrganometry> implements
		SelectableDataModel<CrmHistoryOrganometry>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryOrganometryDataModel() {
	}

	public HistoryOrganometryDataModel(List<CrmHistoryOrganometry> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmHistoryOrganometry getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmHistoryOrganometry> list = (List<CrmHistoryOrganometry>) getWrappedData();

		for (CrmHistoryOrganometry row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmHistoryOrganometry row) {
		return row.getId();
	}
}