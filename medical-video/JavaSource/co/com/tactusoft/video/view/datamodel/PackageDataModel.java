package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidPackage;

public class PackageDataModel extends ListDataModel<VidPackage> implements
		SelectableDataModel<VidPackage>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PackageDataModel() {
	}

	public PackageDataModel(List<VidPackage> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidPackage getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidPackage> list = (List<VidPackage>) getWrappedData();

		for (VidPackage row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidPackage car) {
		return car.getId();
	}
}