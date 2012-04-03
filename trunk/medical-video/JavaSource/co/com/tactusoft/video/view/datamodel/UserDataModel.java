package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.User;

public class UserDataModel extends ListDataModel<User> implements
		SelectableDataModel<User>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDataModel() {
	}

	public UserDataModel(List<User> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<User> list = (List<User>) getWrappedData();

		for (User row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(User car) {
		return car.getId();
	}
}