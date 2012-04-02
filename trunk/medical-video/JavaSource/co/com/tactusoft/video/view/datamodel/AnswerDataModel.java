package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.MedAnswer;

public class AnswerDataModel extends ListDataModel<MedAnswer> implements
		SelectableDataModel<MedAnswer>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerDataModel() {
	}

	public AnswerDataModel(List<MedAnswer> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedAnswer getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedAnswer> list = (List<MedAnswer>) getWrappedData();

		for (MedAnswer row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedAnswer car) {
		return car.getId();
	}
}