package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmDepartment;

public class DepartmentDataModel extends ListDataModel<CrmDepartment> implements
		SelectableDataModel<CrmDepartment>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentDataModel() {
	}

	public DepartmentDataModel(List<CrmDepartment> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmDepartment getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmDepartment> list = (List<CrmDepartment>) getWrappedData();

		for (CrmDepartment row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmDepartment car) {
		return car.getId();
	}
}