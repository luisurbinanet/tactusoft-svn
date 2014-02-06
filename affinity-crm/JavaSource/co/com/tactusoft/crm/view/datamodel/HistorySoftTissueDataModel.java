package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOdontologySoftTissue;

public class HistorySoftTissueDataModel extends
		ListDataModel<CrmOdontologySoftTissue> implements
		SelectableDataModel<CrmOdontologySoftTissue>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistorySoftTissueDataModel() {
	}

	public HistorySoftTissueDataModel(List<CrmOdontologySoftTissue> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOdontologySoftTissue getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOdontologySoftTissue> list = (List<CrmOdontologySoftTissue>) getWrappedData();

		for (CrmOdontologySoftTissue row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOdontologySoftTissue row) {
		return row.getId();
	}
}