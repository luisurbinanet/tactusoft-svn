package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCie;

public class CieDataModel extends ListDataModel<CrmCie> implements
		SelectableDataModel<CrmCie>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CieDataModel() {
	}

	public CieDataModel(List<CrmCie> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCie getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCie> list = (List<CrmCie>) getWrappedData();

		for (CrmCie row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCie obj) {
		return obj.getId();
	}
}