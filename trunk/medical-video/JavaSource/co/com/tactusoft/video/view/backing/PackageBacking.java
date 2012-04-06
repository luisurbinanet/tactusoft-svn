package co.com.tactusoft.video.view.backing;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.video.controller.bo.AdminBo;
import co.com.tactusoft.video.model.entities.VidPackage;
import co.com.tactusoft.video.model.entities.VidPackageTopic;
import co.com.tactusoft.video.model.entities.VidTopic;
import co.com.tactusoft.video.util.Constant;
import co.com.tactusoft.video.util.FacesUtil;
import co.com.tactusoft.video.view.datamodel.PackageDataModel;
import co.com.tactusoft.video.view.datamodel.PackageTopicDataModel;

@Named
@Scope("view")
public class PackageBacking {

	@Inject
	private AdminBo service;

	private List<VidPackage> list;
	private VidPackage selected;
	private PackageDataModel model;

	private List<VidPackageTopic> listDetail;
	private VidPackageTopic selectedDetail;
	private PackageTopicDataModel modelDetail;
	private VidPackageTopic[] selectedDetailArray;

	private List<SelectItem> listTopic;
	private Map<BigDecimal, VidTopic> mapTopic;

	public PackageBacking() {
		model = null;
		selected = new VidPackage();
		selectedDetail = new VidPackageTopic();
		selectedDetail.setVidTopic(new VidTopic());
	}

	public void init() {
		list = service.getListVidPackage();
		model = new PackageDataModel(list);
	}

	public List<VidPackage> getList() {
		return list;
	}

	public void setList(List<VidPackage> list) {
		this.list = list;
	}

	public VidPackage getSelected() {
		return selected;
	}

	public void setSelected(VidPackage selected) {
		this.selected = selected;
	}

	public PackageDataModel getModel() {
		if (model == null) {
			list = service.getListVidPackage();
			model = new PackageDataModel(list);
		}
		return model;
	}

	public List<VidPackageTopic> getListDetail() {
		return listDetail;
	}

	public void setListDetail(List<VidPackageTopic> listDetail) {
		this.listDetail = listDetail;
	}

	public void setModel(PackageDataModel model) {
		this.model = model;
	}

	public VidPackageTopic getSelectedDetail() {
		return selectedDetail;
	}

	public void setSelectedDetail(VidPackageTopic selectedDetail) {
		this.selectedDetail = selectedDetail;
	}

	public PackageTopicDataModel getModelDetail() {
		return modelDetail;
	}

	public void setModelDetail(PackageTopicDataModel modelDetail) {
		this.modelDetail = modelDetail;
	}

	public VidPackageTopic[] getSelectedDetailArray() {
		return selectedDetailArray;
	}

	public void setSelectedDetailArray(VidPackageTopic[] selectedDetailArray) {
		this.selectedDetailArray = selectedDetailArray;
	}

	public List<SelectItem> getListTopic() {
		if (listTopic == null) {
			listTopic = new LinkedList<SelectItem>();
			mapTopic = new HashMap<BigDecimal, VidTopic>();
			for (VidTopic row : service.getListVidTopicActive()) {
				SelectItem item = new SelectItem(row.getId(), row.getName());
				listTopic.add(item);
				mapTopic.put(row.getId(), row);
			}
		}
		return listTopic;
	}

	public void setListTopic(List<SelectItem> listTopic) {
		this.listTopic = listTopic;
	}

	public void newAction() {
		selected = new VidPackage();
	}

	public void newDetailAction() {
		selectedDetail = new VidPackageTopic();
		selectedDetail.setVidTopic(new VidTopic());
	}

	public void refreshAction() {

	}

	public void removeDetailAction() {
		for (VidPackageTopic row : selectedDetailArray) {
			service.remove(row);
			listDetail.remove(row);
		}

		model = new PackageDataModel(list);
	}

	public void saveAction() {
		String message = null;

		if (selected.getId() == null) {
			selected.setId(service.getId("VidPackage"));
			selected.setState(Constant.STATE_ACTIVE);
			message = FacesUtil.getMessage("msg_record_ok_3");
		} else {
			message = FacesUtil.getMessage("msg_record_ok_2");
		}

		service.save(selected);
		list = service.getListVidPackage();
		model = new PackageDataModel(list);

		FacesUtil.addInfo(message);
	}

	public void saveDetailAction() {
		String message = null;

		if (selectedDetail.getId() == null) {
			selectedDetail.setId(service.getId("VidPackageTopic"));
			selectedDetail.setVidPackage(selected);
			message = FacesUtil.getMessage("msg_record_ok_3");
		} else {
			message = FacesUtil.getMessage("msg_record_ok_2");
		}

		selectedDetail.setVidTopic(mapTopic.get(selectedDetail.getVidTopic()
				.getId()));
		service.save(selectedDetail);
		listDetail = service.getListVidPackageTopicByPackage(selected.getId());
		modelDetail = new PackageTopicDataModel(listDetail);

		FacesUtil.addInfo(message);
	}

	public void onRowSelect(SelectEvent event) {
		BigDecimal idBody = ((VidPackage) event.getObject()).getId();
		listDetail = service.getListVidPackageTopicByPackage(idBody);
		modelDetail = new PackageTopicDataModel(listDetail);
	}

}
