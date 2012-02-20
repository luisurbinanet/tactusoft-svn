package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiCompany;

public class KpiCompanyModel extends ListDataModel<KpiCompany> implements
		SelectableDataModel<KpiCompany> {

	public KpiCompanyModel() {
	}

	public KpiCompanyModel(List<KpiCompany> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiCompany getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiCompany> list = (List<KpiCompany>) getWrappedData();

		for (KpiCompany row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiCompany car) {
		return car.getId();
	}
}