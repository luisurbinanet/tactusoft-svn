package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmNurse;

public class NurseDataModel extends ListDataModel<CrmNurse> implements
		SelectableDataModel<CrmNurse>, Serializable {

	private static final long serialVersionUID = 1L;

	public NurseDataModel() {
	}

	public NurseDataModel(List<CrmNurse> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmNurse getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmNurse> list = (List<CrmNurse>) getWrappedData();

		for (CrmNurse row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmNurse car) {
		return car.getId();
	}
}