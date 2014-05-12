package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.PrcReportCampaignTotal;

public class PrcReportCampaignTotalDataModel extends ListDataModel<PrcReportCampaignTotal> implements
		SelectableDataModel<PrcReportCampaignTotal>, Serializable {

	private static final long serialVersionUID = 1L;

	public PrcReportCampaignTotalDataModel() {
	}

	public PrcReportCampaignTotalDataModel(List<PrcReportCampaignTotal> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PrcReportCampaignTotal getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<PrcReportCampaignTotal> list = (List<PrcReportCampaignTotal>) getWrappedData();

		for (PrcReportCampaignTotal row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(PrcReportCampaignTotal car) {
		return car.getId();
	}
}