package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.MedTopic;

public class TopicDataModel extends ListDataModel<MedTopic> implements
		SelectableDataModel<MedTopic>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TopicDataModel() {
	}

	public TopicDataModel(List<MedTopic> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedTopic getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedTopic> list = (List<MedTopic>) getWrappedData();

		for (MedTopic row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedTopic car) {
		return car.getId();
	}
}