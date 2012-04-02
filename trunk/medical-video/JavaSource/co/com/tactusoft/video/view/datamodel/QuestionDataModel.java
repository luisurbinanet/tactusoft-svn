package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.MedQuestion;

public class QuestionDataModel extends ListDataModel<MedQuestion> implements
		SelectableDataModel<MedQuestion>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionDataModel() {
	}

	public QuestionDataModel(List<MedQuestion> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedQuestion getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedQuestion> list = (List<MedQuestion>) getWrappedData();

		for (MedQuestion row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedQuestion car) {
		return car.getId();
	}
}