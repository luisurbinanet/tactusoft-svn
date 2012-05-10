package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmProcedure;

public class ProcedureDataModel extends ListDataModel<CrmProcedure> implements
		SelectableDataModel<CrmProcedure>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProcedureDataModel() {
	}

	public ProcedureDataModel(List<CrmProcedure> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmProcedure getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmProcedure> list = (List<CrmProcedure>) getWrappedData();

		for (CrmProcedure row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmProcedure car) {
		return car.getId();
	}
}