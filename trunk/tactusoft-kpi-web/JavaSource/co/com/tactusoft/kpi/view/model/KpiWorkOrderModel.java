package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiWorkOrder;

public class KpiWorkOrderModel extends ListDataModel<KpiWorkOrder> implements
		SelectableDataModel<KpiWorkOrder> {

	public KpiWorkOrderModel() {
	}

	public KpiWorkOrderModel(List<KpiWorkOrder> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiWorkOrder getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiWorkOrder> list = (List<KpiWorkOrder>) getWrappedData();

		for (KpiWorkOrder row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiWorkOrder car) {
		return car.getId();
	}
}