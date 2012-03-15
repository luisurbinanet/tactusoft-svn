package co.com.tactusoft.medical.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.medical.model.entities.MedCombination;

public class CombinationDataModel extends ListDataModel<MedCombination> implements
		SelectableDataModel<MedCombination>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CombinationDataModel() {
	}

	public CombinationDataModel(List<MedCombination> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedCombination getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedCombination> list = (List<MedCombination>) getWrappedData();

		for (MedCombination row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedCombination car) {
		return car.getId();
	}
}