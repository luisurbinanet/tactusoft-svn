package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCampaignMedication;

public class CampaignMedicationlDataModel extends ListDataModel<CrmCampaignMedication>
		implements SelectableDataModel<CrmCampaignMedication>, Serializable {

	private static final long serialVersionUID = 1L;

	public CampaignMedicationlDataModel() {
	}

	public CampaignMedicationlDataModel(List<CrmCampaignMedication> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCampaignMedication getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCampaignMedication> list = (List<CrmCampaignMedication>) getWrappedData();

		for (CrmCampaignMedication row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCampaignMedication row) {
		return row.getId();
	}
}