package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class ReportDailyModel extends ListDataModel<ReportDaily> implements
		SelectableDataModel<ReportDaily> {

	public ReportDailyModel() {
	}

	public ReportDailyModel(List<ReportDaily> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ReportDaily getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<ReportDaily> list = (List<ReportDaily>) getWrappedData();

		for (ReportDaily row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(ReportDaily entity) {
		return entity.getId();
	}
}