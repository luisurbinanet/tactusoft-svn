package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCieMaterial;

public class CieMaterialDataModel extends ListDataModel<CrmCieMaterial> implements
		SelectableDataModel<CrmCieMaterial>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CieMaterialDataModel() {
	}

	public CieMaterialDataModel(List<CrmCieMaterial> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCieMaterial getRowData(String rowKey) {
		// In a real app, a more effiCieMaterialnt way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCieMaterial> list = (List<CrmCieMaterial>) getWrappedData();

		for (CrmCieMaterial row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCieMaterial obj) {
		return obj.getId();
	}
}