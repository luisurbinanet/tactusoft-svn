package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmMarketingActivity;

public class MarketingActivityDataModel extends ListDataModel<CrmMarketingActivity> implements
		SelectableDataModel<CrmMarketingActivity>, Serializable {

	private static final long serialVersionUID = 1L;

	public MarketingActivityDataModel() {
	}

	public MarketingActivityDataModel(List<CrmMarketingActivity> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmMarketingActivity getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmMarketingActivity> list = (List<CrmMarketingActivity>) getWrappedData();

		for (CrmMarketingActivity row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmMarketingActivity car) {
		return car.getId();
	}
}