package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmDoctorException;

public class DoctorExceptionDataModel extends ListDataModel<CrmDoctorException> implements
		SelectableDataModel<CrmDoctorException>, Serializable {

	private static final long serialVersionUID = 1L;

	public DoctorExceptionDataModel() {
	}

	public DoctorExceptionDataModel(List<CrmDoctorException> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmDoctorException getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmDoctorException> list = (List<CrmDoctorException>) getWrappedData();

		for (CrmDoctorException row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmDoctorException car) {
		return car.getId();
	}
}