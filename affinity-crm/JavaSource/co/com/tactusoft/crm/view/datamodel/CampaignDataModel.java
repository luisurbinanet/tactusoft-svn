package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmCampaign;

public class CampaignDataModel extends ListDataModel<CrmCampaign> implements
		SelectableDataModel<CrmCampaign>, Serializable {

	private static final long serialVersionUID = 1L;

	public CampaignDataModel() {
	}

	public CampaignDataModel(List<CrmCampaign> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmCampaign getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmCampaign> list = (List<CrmCampaign>) getWrappedData();

		for (CrmCampaign row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmCampaign row) {
		return row.getId();
	}
}