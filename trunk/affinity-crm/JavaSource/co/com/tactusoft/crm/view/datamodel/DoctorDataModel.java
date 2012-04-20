package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmDoctor;

public class DoctorDataModel extends ListDataModel<CrmDoctor> implements
		SelectableDataModel<CrmDoctor>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DoctorDataModel() {
	}

	public DoctorDataModel(List<CrmDoctor> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmDoctor getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmDoctor> list = (List<CrmDoctor>) getWrappedData();

		for (CrmDoctor row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmDoctor car) {
		return car.getId();
	}
}