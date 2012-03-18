package co.com.tactusoft.medical.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.medical.model.entities.MedUser;

public class UserDataModel extends ListDataModel<MedUser> implements
		SelectableDataModel<MedUser>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDataModel() {
	}

	public UserDataModel(List<MedUser> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedUser getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedUser> list = (List<MedUser>) getWrappedData();

		for (MedUser row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedUser car) {
		return car.getId();
	}
}