package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmMedication;

public class MedicationDataModel extends ListDataModel<CrmMedication> implements
		SelectableDataModel<CrmMedication>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MedicationDataModel() {
	}

	public MedicationDataModel(List<CrmMedication> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmMedication getRowData(String rowKey) {
		// In a real app, a more effiMedicationnt way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmMedication> list = (List<CrmMedication>) getWrappedData();

		for (CrmMedication row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmMedication obj) {
		return obj.getId();
	}
}