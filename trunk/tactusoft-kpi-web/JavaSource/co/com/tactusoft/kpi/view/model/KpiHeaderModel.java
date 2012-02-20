package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiHeader;

public class KpiHeaderModel extends ListDataModel<KpiHeader> implements
		SelectableDataModel<KpiHeader> {

	public KpiHeaderModel() {
	}

	public KpiHeaderModel(List<KpiHeader> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiHeader getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiHeader> list = (List<KpiHeader>) getWrappedData();

		for (KpiHeader row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiHeader car) {
		return car.getId();
	}
}