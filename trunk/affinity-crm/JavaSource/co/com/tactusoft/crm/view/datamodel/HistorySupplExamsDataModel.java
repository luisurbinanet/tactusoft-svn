package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmOdontologySupplExams;

public class HistorySupplExamsDataModel extends
		ListDataModel<CrmOdontologySupplExams> implements
		SelectableDataModel<CrmOdontologySupplExams>, Serializable {

	private static final long serialVersionUID = 1L;

	public HistorySupplExamsDataModel() {
	}

	public HistorySupplExamsDataModel(List<CrmOdontologySupplExams> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmOdontologySupplExams getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmOdontologySupplExams> list = (List<CrmOdontologySupplExams>) getWrappedData();

		for (CrmOdontologySupplExams row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmOdontologySupplExams row) {
		return row.getId();
	}
}