package co.com.tactusoft.medical.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class CombinationDataModel extends ListDataModel<Combination> implements
		SelectableDataModel<Combination>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CombinationDataModel() {
	}

	public CombinationDataModel(List<Combination> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Combination getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Combination> list = (List<Combination>) getWrappedData();

		for (Combination row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(Combination car) {
		return car.getId();
	}
}