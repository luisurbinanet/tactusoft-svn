package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiGroup;

public class KpiGroupModel extends ListDataModel<KpiGroup> implements
		SelectableDataModel<KpiGroup> {

	public KpiGroupModel() {
	}

	public KpiGroupModel(List<KpiGroup> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiGroup getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiGroup> list = (List<KpiGroup>) getWrappedData();

		for (KpiGroup row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiGroup car) {
		return car.getId();
	}
}