package co.com.tactusoft.crm.view.datamodel;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.com.tactusoft.crm.view.beans.Material;

public class MaterialDataModel extends ListDataModel<Material> implements
		SelectableDataModel<Material>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MaterialDataModel() {
	}

	public MaterialDataModel(List<Material> data) {
		super(data);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Material getRowData(String rowKey) {
		// In a real app, a more efficient way like a query by rowKey should be
		// implemented to deal with huge data

		List<Material> list = (List<Material>) getWrappedData();

		for (Material row : list) {
			if (row.getCode().equals(rowKey))
				return row;
		}

		return null;
	}

	@Override
	public Object getRowKey(Material car) {
		return car.getCode();
	}
}