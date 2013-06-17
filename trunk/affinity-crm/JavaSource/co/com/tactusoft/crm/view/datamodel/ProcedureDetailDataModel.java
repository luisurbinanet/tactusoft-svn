package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmProcedureDetail;

public class ProcedureDetailDataModel extends ListDataModel<CrmProcedureDetail>
		implements SelectableDataModel<CrmProcedureDetail>, Serializable {

	private static final long serialVersionUID = 1L;

	public ProcedureDetailDataModel() {
	}

	public ProcedureDetailDataModel(List<CrmProcedureDetail> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmProcedureDetail getRowData(String rowKey) {
		List<CrmProcedureDetail> list = (List<CrmProcedureDetail>) getWrappedData();

		for (CrmProcedureDetail row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmProcedureDetail car) {
		return car.getId();
	}
}