package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.VwPatientTicket;

public class VwPatientTicketDataModel extends ListDataModel<VwPatientTicket> implements
		SelectableDataModel<VwPatientTicket>, Serializable {

	private static final long serialVersionUID = 1L;

	public VwPatientTicketDataModel() {
	}

	public VwPatientTicketDataModel(List<VwPatientTicket> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VwPatientTicket getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VwPatientTicket> list = (List<VwPatientTicket>) getWrappedData();

		for (VwPatientTicket row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VwPatientTicket car) {
		return car.getId();
	}
}