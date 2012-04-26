package co.com.tactusoft.kpi.view.model;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.kpi.model.entities.KpiDailyDelayWo;

public class KpiDailyDelayWOModel extends ListDataModel<KpiDailyDelayWo> implements
		SelectableDataModel<KpiDailyDelayWo> {

	public KpiDailyDelayWOModel() {
	}

	public KpiDailyDelayWOModel(List<KpiDailyDelayWo> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public KpiDailyDelayWo getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<KpiDailyDelayWo> list = (List<KpiDailyDelayWo>) getWrappedData();

		for (KpiDailyDelayWo row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(KpiDailyDelayWo entity) {
		return entity.getId();
	}
}