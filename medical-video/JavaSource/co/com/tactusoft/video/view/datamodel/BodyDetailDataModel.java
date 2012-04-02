package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.MedBodyDetail;

public class BodyDetailDataModel extends ListDataModel<MedBodyDetail> implements
		SelectableDataModel<MedBodyDetail>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BodyDetailDataModel() {
	}

	public BodyDetailDataModel(List<MedBodyDetail> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public MedBodyDetail getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<MedBodyDetail> list = (List<MedBodyDetail>) getWrappedData();

		for (MedBodyDetail row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(MedBodyDetail car) {
		return car.getId();
	}
}