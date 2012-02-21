package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiHeaderDelay;

public class KpiHeaderDelayModel extends ListDataModel<KpiHeaderDelay> implements
		SelectableDataModel<KpiHeaderDelay> {

	public KpiHeaderDelayModel() {
	}

	public KpiHeaderDelayModel(List<KpiHeaderDelay> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiHeaderDelay getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiHeaderDelay> list = (List<KpiHeaderDelay>) getWrappedData();

		for (KpiHeaderDelay row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiHeaderDelay car) {
		return car.getId();
	}
}