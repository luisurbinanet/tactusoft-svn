package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.view.beans.Candidate;

public class CandidateDataModel extends ListDataModel<Candidate> implements
		SelectableDataModel<Candidate>, Serializable {

	private static final long serialVersionUID = 1L;

	public CandidateDataModel() {
	}

	public CandidateDataModel(List<Candidate> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Candidate getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Candidate> list = (List<Candidate>) getWrappedData();

		for (Candidate row : list) {
			if (String.valueOf(row.getId()).equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(Candidate car) {
		return car.getId();
	}
}