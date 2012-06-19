package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmPatient;

public class PatientDataModel extends ListDataModel<CrmPatient> implements
		SelectableDataModel<CrmPatient>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientDataModel() {
	}

	public PatientDataModel(List<CrmPatient> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmPatient getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmPatient> list = (List<CrmPatient>) getWrappedData();

		for (CrmPatient row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmPatient car) {
		return car.getId();
	}
}