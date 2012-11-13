package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCampaignDetail;

public class CampaignDetailDataModel extends ListDataModel<CrmCampaignDetail>
		implements SelectableDataModel<CrmCampaignDetail>, Serializable {

	private static final long serialVersionUID = 1L;

	public CampaignDetailDataModel() {
	}

	public CampaignDetailDataModel(List<CrmCampaignDetail> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCampaignDetail getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCampaignDetail> list = (List<CrmCampaignDetail>) getWrappedData();

		for (CrmCampaignDetail row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCampaignDetail row) {
		return row.getId();
	}
}