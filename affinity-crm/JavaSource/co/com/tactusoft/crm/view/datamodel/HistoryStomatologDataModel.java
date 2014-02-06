package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOdontologyStomatolog;

public class HistoryStomatologDataModel extends
		ListDataModel<CrmOdontologyStomatolog> implements
		SelectableDataModel<CrmOdontologyStomatolog>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryStomatologDataModel() {
	}

	public HistoryStomatologDataModel(List<CrmOdontologyStomatolog> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOdontologyStomatolog getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOdontologyStomatolog> list = (List<CrmOdontologyStomatolog>) getWrappedData();

		for (CrmOdontologyStomatolog row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOdontologyStomatolog row) {
		return row.getId();
	}
}