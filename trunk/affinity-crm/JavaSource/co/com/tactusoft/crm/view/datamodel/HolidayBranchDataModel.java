package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmHolidayBranch;

public class HolidayBranchDataModel extends ListDataModel<CrmHolidayBranch> implements
		SelectableDataModel<CrmHolidayBranch>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HolidayBranchDataModel() {
	}

	public HolidayBranchDataModel(List<CrmHolidayBranch> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmHolidayBranch getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmHolidayBranch> list = (List<CrmHolidayBranch>) getWrappedData();

		for (CrmHolidayBranch row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmHolidayBranch car) {
		return car.getId();
	}
}