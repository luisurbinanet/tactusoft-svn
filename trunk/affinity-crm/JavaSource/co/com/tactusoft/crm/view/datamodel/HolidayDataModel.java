package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmHoliday;

public class HolidayDataModel extends ListDataModel<CrmHoliday> implements
		SelectableDataModel<CrmHoliday>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HolidayDataModel() {
	}

	public HolidayDataModel(List<CrmHoliday> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmHoliday getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmHoliday> list = (List<CrmHoliday>) getWrappedData();

		for (CrmHoliday row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmHoliday car) {
		return car.getId();
	}
}