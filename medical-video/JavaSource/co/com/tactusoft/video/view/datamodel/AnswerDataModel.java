package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidAnswer;

public class AnswerDataModel extends ListDataModel<VidAnswer> implements
		SelectableDataModel<VidAnswer>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerDataModel() {
	}

	public AnswerDataModel(List<VidAnswer> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidAnswer getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidAnswer> list = (List<VidAnswer>) getWrappedData();

		for (VidAnswer row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidAnswer car) {
		return car.getId();
	}
}