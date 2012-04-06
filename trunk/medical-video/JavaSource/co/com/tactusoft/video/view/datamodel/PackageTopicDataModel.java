package co.com.tactusoft.video.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.video.model.entities.VidPackageTopic;

public class PackageTopicDataModel extends ListDataModel<VidPackageTopic> implements
		SelectableDataModel<VidPackageTopic>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PackageTopicDataModel() {
	}

	public PackageTopicDataModel(List<VidPackageTopic> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VidPackageTopic getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<VidPackageTopic> list = (List<VidPackageTopic>) getWrappedData();

		for (VidPackageTopic row : list) {
			if (row.getId().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(VidPackageTopic car) {
		return car.getId();
	}
}