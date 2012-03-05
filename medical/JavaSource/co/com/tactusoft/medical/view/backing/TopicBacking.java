package co.com.tactusoft.medical.view.backing;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.model.entities.MedTopic;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.QuestionDataModel;
import co.com.tactusoft.medical.view.datamodel.TopicDataModel;

@Named
@Scope("session")
public class TopicBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private AdminBo service;

	private TopicDataModel model;
	private MedTopic selected;

	private QuestionDataModel modelQuestion;
	private MedQuestion selectedQuestion;
	private List<MedQuestion> listQuestion;

	private TreeNode root;

	private TreeNode selectedNode;

	private TreeNode[] selectedNodes;

	public TopicBacking() {
		selected = new MedTopic();
		selectedQuestion = new MedQuestion();
		model = null;
		root = new DefaultTreeNode("Root", null);
	}

	public TopicDataModel getModel() {
		if (model == null) {
			model = new TopicDataModel(service.getListMedTopic());
		}
		return model;
	}

	public void setModel(TopicDataModel model) {
		this.model = model;
	}

	public MedTopic getSelected() {
		return selected;
	}

	public void setSelected(MedTopic selected) {
		if (selected == null) {
			selected = new MedTopic();
		}
		this.selected = selected;
	}

	public QuestionDataModel getModelQuestion() {
		return modelQuestion;
	}

	public void setModelQuestion(QuestionDataModel modelQuestion) {
		this.modelQuestion = modelQuestion;
	}

	public MedQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(MedQuestion selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
	}

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public void newAction() {
		selected = new MedTopic();
	}

	public void deleteAction() {
		service.remove(selected);
		model = new TopicDataModel(service.getListMedTopic());
	}

	public void saveAction() {

		String message = null;
		RequestContext context = RequestContext.getCurrentInstance();

		if (selected.getId() == null) {
			selected.setId(service.getId("KpiCompany"));
			selected.setState(Constant.STATE_ACTIVE);
			selected.setNumVersion(1);
		}

		service.save(selected);
		message = FacesUtil.getMessage("msg_record_ok", selected.getName());
		model = new TopicDataModel(service.getListMedTopic());
		FacesUtil.addInfo(message);

		context.addCallbackParam("saved", "true");

	}

	public void onRowSelect(SelectEvent event) {
		BigDecimal idTopic = ((MedTopic) event.getObject()).getId();
		listQuestion = service.getListMedQuestionByTopic(idTopic);
		modelQuestion = new QuestionDataModel(listQuestion);
		selectedQuestion = new MedQuestion();

		/*root = new DefaultTreeNode("Root", null);

		Map<BigDecimal, MedQuestion> mapParents = new HashMap<BigDecimal, MedQuestion>();
		for (MedQuestion row : listQuestion) {
			mapParents.put(row.getIdParent(), row);
		}

		for (MedQuestion row : mapParents.values()) {
			TreeNode node = null;
			for (MedQuestion row2 : listQuestion) {
				if (row.getIdParent().intValue() == row2.getIdParent()
						.intValue()) {
					node = new DefaultTreeNode(row, root);
				}
			}
			root = node;
		}*/

	}

	public String goQuestionAction() {
		QuestionBacking questionBacking = FacesUtil.findBean("questionBacking");
		String action = FacesUtil.getParam("action");
		if (action.equals("NEW")) {
			selectedQuestion = new MedQuestion();
		}
		selectedQuestion.setMedTopic(selected);
		questionBacking.init(selected.getId(), selectedQuestion);
		return "/pages/admin/question?faces-redirect=true";
	}

	public void onNodeExpand(NodeExpandEvent event) {
		FacesUtil.addInfo("Expanded");
	}

	public void onNodeCollapse(NodeCollapseEvent event) {
		FacesUtil.addInfo("Collapsed");
	}

	public void onNodeSelect(NodeSelectEvent event) {
		FacesUtil.addInfo("Selected");
	}

	public void onNodeUnselect(NodeUnselectEvent event) {
		FacesUtil.addInfo("Unselected");
	}

	public void onDragDrop(DragDropEvent event) {
		TreeNode node = (TreeNode) event.getData();
		FacesUtil.addInfo("DragDrop", node + " moved to " + node.getParent());
	}

	public void deleteNode() {
		selectedNode.getChildren().clear();
		selectedNode.getParent().getChildren().remove(selectedNode);
		selectedNode.setParent(null);

		selectedNode = null;
	}

}
