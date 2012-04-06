package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidUserTopic;

public class UserTopicDataModel extends ListDataModel<VidUserTopic> implements
		SelectableDataModel<VidUserTopic>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserTopicDataModel() {
	}

	public UserTopicDataModel(List<VidUserTopic> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidUserTopic getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidUserTopic> list = (List<VidUserTopic>) getWrappedData();

		for (VidUserTopic row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidUserTopic car) {
		return car.getId();
	}
}