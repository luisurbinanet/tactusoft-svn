package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmHistoryRecord;

public class HistoryRecordDataModel extends ListDataModel<CrmHistoryRecord> implements
		SelectableDataModel<CrmHistoryRecord>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryRecordDataModel() {
	}

	public HistoryRecordDataModel(List<CrmHistoryRecord> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmHistoryRecord getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmHistoryRecord> list = (List<CrmHistoryRecord>) getWrappedData();

		for (CrmHistoryRecord row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmHistoryRecord row) {
		return row.getId();
	}
}