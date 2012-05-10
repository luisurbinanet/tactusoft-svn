package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmDoctorSchedule;

public class DoctorScheduleDataModel extends ListDataModel<CrmDoctorSchedule> implements
		SelectableDataModel<CrmDoctorSchedule>, Serializable {

	private static final long serialVersionUID = 1L;

	public DoctorScheduleDataModel() {
	}

	public DoctorScheduleDataModel(List<CrmDoctorSchedule> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmDoctorSchedule getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmDoctorSchedule> list = (List<CrmDoctorSchedule>) getWrappedData();

		for (CrmDoctorSchedule row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmDoctorSchedule car) {
		return car.getId();
	}
}