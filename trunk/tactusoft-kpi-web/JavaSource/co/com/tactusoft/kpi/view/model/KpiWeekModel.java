package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiWeek;

public class KpiWeekModel extends ListDataModel<KpiWeek> implements
		SelectableDataModel<KpiWeek> {

	public KpiWeekModel() {
	}

	public KpiWeekModel(List<KpiWeek> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiWeek getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiWeek> list = (List<KpiWeek>) getWrappedData();

		for (KpiWeek row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiWeek car) {
		return car.getId();
	}
}