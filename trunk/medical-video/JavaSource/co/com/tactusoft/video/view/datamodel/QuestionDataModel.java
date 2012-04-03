package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidQuestion;

public class QuestionDataModel extends ListDataModel<VidQuestion> implements
		SelectableDataModel<VidQuestion>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionDataModel() {
	}

	public QuestionDataModel(List<VidQuestion> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidQuestion getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidQuestion> list = (List<VidQuestion>) getWrappedData();

		for (VidQuestion row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidQuestion car) {
		return car.getId();
	}
}