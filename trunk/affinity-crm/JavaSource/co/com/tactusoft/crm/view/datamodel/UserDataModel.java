package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmUser;

public class UserDataModel extends ListDataModel<CrmUser> implements
		SelectableDataModel<CrmUser>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDataModel() {
	}

	public UserDataModel(List<CrmUser> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmUser getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmUser> list = (List<CrmUser>) getWrappedData();

		for (CrmUser row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmUser car) {
		return car.getId();
	}
}