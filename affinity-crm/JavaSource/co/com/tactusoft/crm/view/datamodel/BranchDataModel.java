package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.model.entities.CrmBranch;

public class BranchDataModel extends ListDataModel<CrmBranch> implements
		SelectableDataModel<CrmBranch>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BranchDataModel() {
	}

	public BranchDataModel(List<CrmBranch> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CrmBranch getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<CrmBranch> list = (List<CrmBranch>) getWrappedData();

		for (CrmBranch row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(CrmBranch car) {
		return car.getId();
	}
}