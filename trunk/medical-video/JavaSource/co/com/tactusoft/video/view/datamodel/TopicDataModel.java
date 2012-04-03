package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidTopic;

public class TopicDataModel extends ListDataModel<VidTopic> implements
		SelectableDataModel<VidTopic>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopicDataModel() {
	}

	public TopicDataModel(List<VidTopic> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidTopic getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidTopic> list = (List<VidTopic>) getWrappedData();

		for (VidTopic row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidTopic car) {
		return car.getId();
	}
}