package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.PrcReportCampaign;

public class PrcReportCampaignDataModel extends ListDataModel<PrcReportCampaign> implements
		SelectableDataModel<PrcReportCampaign>, Serializable {

	private static final long serialVersionUID = 1L;

	public PrcReportCampaignDataModel() {
	}

	public PrcReportCampaignDataModel(List<PrcReportCampaign> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PrcReportCampaign getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<PrcReportCampaign> list = (List<PrcReportCampaign>) getWrappedData();

		for (PrcReportCampaign row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(PrcReportCampaign car) {
		return car.getId();
	}
}