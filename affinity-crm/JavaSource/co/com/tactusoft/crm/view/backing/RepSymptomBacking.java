package co.com.tactusoft.crm.view.backing;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.crm.model.entities.CrmRepMedication;
import co.com.tactusoft.crm.model.entities.CrmRepSymptom;

@Named
@Scope("view")
public class RepSymptomBacking extends BaseBacking implements Serializable {

	private static final long serialVersionUID = 1L;

	private TreeNode root;
	private TreeNode rootMedication;
	private TreeNode selectedNode;
	private String symptom;

	public RepSymptomBacking() {

	}

	@PostConstruct
	public void init() {
		root = new DefaultTreeNode("root", null);
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRootMedication() {
		return rootMedication;
	}

	public void setRootMedication(TreeNode rootMedication) {
		this.rootMedication = rootMedication;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public void searchAction(ActionEvent event) {
		root = new DefaultTreeNode("root", null);

		List<CrmRepSymptom> listCrmRepSymptom = processService
				.getListRepSymptom(symptom);
		Map<String, CrmRepSymptom> mapCrmRepSymptom = new TreeMap<String, CrmRepSymptom>();
		for (CrmRepSymptom row : listCrmRepSymptom) {
			mapCrmRepSymptom.put(row.getChapter(), row);
		}

		for (Map.Entry<String, CrmRepSymptom> entry : mapCrmRepSymptom
				.entrySet()) {
			TreeNode chapter = new DefaultTreeNode(new CrmRepSymptom(
					"Documents", entry.getValue().getChapter()), root);
			for (CrmRepSymptom row : listCrmRepSymptom) {
				if (row.getChapter().equals(entry.getValue().getChapter())) {
					TreeNode sym = new DefaultTreeNode("symptom", row, chapter);
				}
			}
		}
	}

	public void onNodeSelect(NodeSelectEvent event) {
		CrmRepSymptom crmRepSymptom = (CrmRepSymptom) selectedNode.getData();
		List<CrmRepMedication> listCrmRepSymptom = processService
				.getListRepMedication(crmRepSymptom.getId());

		rootMedication = new DefaultTreeNode("root", null);
		for (CrmRepMedication row : listCrmRepSymptom) {
			TreeNode med = new DefaultTreeNode("medication", row,
					rootMedication);
		}
	}

}
