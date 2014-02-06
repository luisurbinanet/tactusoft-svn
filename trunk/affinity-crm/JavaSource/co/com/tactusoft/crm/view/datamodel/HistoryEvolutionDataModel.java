package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOdontologyEvolution;

public class HistoryEvolutionDataModel extends
		ListDataModel<CrmOdontologyEvolution> implements
		SelectableDataModel<CrmOdontologyEvolution>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistoryEvolutionDataModel() {
	}

	public HistoryEvolutionDataModel(List<CrmOdontologyEvolution> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOdontologyEvolution getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOdontologyEvolution> list = (List<CrmOdontologyEvolution>) getWrappedData();

		for (CrmOdontologyEvolution row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOdontologyEvolution row) {
		return row.getId();
	}
}