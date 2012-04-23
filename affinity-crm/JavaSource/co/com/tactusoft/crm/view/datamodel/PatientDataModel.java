package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.view.beans.Patient;

public class PatientDataModel extends ListDataModel<Patient> implements
		SelectableDataModel<Patient>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PatientDataModel() {
	}

	public PatientDataModel(List<Patient> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Patient> list = (List<Patient>) getWrappedData();

		for (Patient row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(Patient car) {
		return car.getId();
	}
}