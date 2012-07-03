package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOccupation;

public class OccupationDataModel extends ListDataModel<CrmOccupation> implements
		SelectableDataModel<CrmOccupation>, Serializable {

	private static final long serialVersionUID = 1L;

	public OccupationDataModel() {
	}

	public OccupationDataModel(List<CrmOccupation> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOccupation getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOccupation> list = (List<CrmOccupation>) getWrappedData();

		for (CrmOccupation row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOccupation car) {
		return car.getId();
	}
}