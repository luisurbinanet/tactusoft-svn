package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiDelay;

public class KpiDelayModel extends ListDataModel<KpiDelay> implements
		SelectableDataModel<KpiDelay> {

	public KpiDelayModel() {
	}

	public KpiDelayModel(List<KpiDelay> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiDelay getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiDelay> list = (List<KpiDelay>) getWrappedData();

		for (KpiDelay row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiDelay car) {
		return car.getId();
	}
}