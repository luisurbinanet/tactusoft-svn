package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmSpeciality;

public class SpecialityDataModel extends ListDataModel<CrmSpeciality> implements
		SelectableDataModel<CrmSpeciality>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecialityDataModel() {
	}

	public SpecialityDataModel(List<CrmSpeciality> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmSpeciality getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmSpeciality> list = (List<CrmSpeciality>) getWrappedData();

		for (CrmSpeciality row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmSpeciality car) {
		return car.getId();
	}
}