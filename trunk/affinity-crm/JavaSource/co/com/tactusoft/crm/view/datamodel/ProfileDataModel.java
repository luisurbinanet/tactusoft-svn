package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmProfile;

public class ProfileDataModel extends ListDataModel<CrmProfile> implements
		SelectableDataModel<CrmProfile>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfileDataModel() {
	}

	public ProfileDataModel(List<CrmProfile> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmProfile getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmProfile> list = (List<CrmProfile>) getWrappedData();

		for (CrmProfile row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmProfile car) {
		return car.getId();
	}
}