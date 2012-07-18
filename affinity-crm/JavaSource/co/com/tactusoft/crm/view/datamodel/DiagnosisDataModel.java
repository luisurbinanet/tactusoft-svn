package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmDiagnosis;

public class DiagnosisDataModel extends ListDataModel<CrmDiagnosis> implements
		SelectableDataModel<CrmDiagnosis>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DiagnosisDataModel() {
	}

	public DiagnosisDataModel(List<CrmDiagnosis> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmDiagnosis getRowData(String rowKey) {
		// In a real app, a more effiDiagnosisnt way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmDiagnosis> list = (List<CrmDiagnosis>) getWrappedData();

		for (CrmDiagnosis row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmDiagnosis obj) {
		return obj.getId();
	}
}