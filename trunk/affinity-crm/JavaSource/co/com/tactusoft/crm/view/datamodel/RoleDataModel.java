package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmRole;

public class RoleDataModel extends ListDataModel<CrmRole> implements
		SelectableDataModel<CrmRole>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoleDataModel() {
	}

	public RoleDataModel(List<CrmRole> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmRole getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmRole> list = (List<CrmRole>) getWrappedData();

		for (CrmRole row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmRole car) {
		return car.getId();
	}
}