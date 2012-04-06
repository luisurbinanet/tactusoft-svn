package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidUserPackage;

public class UserPackageDataModel extends ListDataModel<VidUserPackage> implements
		SelectableDataModel<VidUserPackage>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserPackageDataModel() {
	}

	public UserPackageDataModel(List<VidUserPackage> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidUserPackage getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidUserPackage> list = (List<VidUserPackage>) getWrappedData();

		for (VidUserPackage row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidUserPackage car) {
		return car.getId();
	}
}