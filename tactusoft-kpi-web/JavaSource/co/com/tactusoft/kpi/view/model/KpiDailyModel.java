package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiDaily;

public class KpiDailyModel extends ListDataModel<KpiDaily> implements
		SelectableDataModel<KpiDaily> {

	public KpiDailyModel() {
	}

	public KpiDailyModel(List<KpiDaily> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiDaily getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiDaily> list = (List<KpiDaily>) getWrappedData();

		for (KpiDaily row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiDaily entity) {
		return entity.getId();
	}
}