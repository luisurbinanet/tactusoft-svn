package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.MedBody;

public class BodyDataModel extends ListDataModel<MedBody> implements
		SelectableDataModel<MedBody>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BodyDataModel() {
	}

	public BodyDataModel(List<MedBody> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedBody getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedBody> list = (List<MedBody>) getWrappedData();

		for (MedBody row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedBody car) {
		return car.getId();
	}
}