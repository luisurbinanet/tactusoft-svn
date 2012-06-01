package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmAppointment;

public class AppointmentDataModel extends ListDataModel<CrmAppointment> implements
		SelectableDataModel<CrmAppointment>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppointmentDataModel() {
	}

	public AppointmentDataModel(List<CrmAppointment> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmAppointment getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmAppointment> list = (List<CrmAppointment>) getWrappedData();

		for (CrmAppointment row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmAppointment car) {
		return car.getId();
	}
}