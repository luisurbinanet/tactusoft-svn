package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiConfig;

public class KpiConfigModel extends ListDataModel<KpiConfig> implements
		SelectableDataModel<KpiConfig> {

	public KpiConfigModel() {
	}

	public KpiConfigModel(List<KpiConfig> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiConfig getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiConfig> list = (List<KpiConfig>) getWrappedData();

		for (KpiConfig row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiConfig car) {
		return car.getId();
	}
}