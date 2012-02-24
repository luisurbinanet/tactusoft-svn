package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiDailyDelay;

public class KpiDailyDelayModel extends ListDataModel<KpiDailyDelay> implements
		SelectableDataModel<KpiDailyDelay> {

	public KpiDailyDelayModel() {
	}

	public KpiDailyDelayModel(List<KpiDailyDelay> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiDailyDelay getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiDailyDelay> list = (List<KpiDailyDelay>) getWrappedData();

		for (KpiDailyDelay row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiDailyDelay entity) {
		return entity.getId();
	}
}