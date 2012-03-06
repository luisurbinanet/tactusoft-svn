package co.com.tactusoft.medical.view.backing;

import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.model.entities.MedQuestion;

@Named
@Scope("session")
public class ResponseQuestionBacking {
	
	private List<MedQuestion> list;
	private MedQuestion selectedQuestion;
	
	public ResponseQuestionBacking(){
		
	}

	public List<MedQuestion> getList() {
		return list;
	}

	public void setList(List<MedQuestion> list) {
		this.list = list;
	}

	public MedQuestion getSelectedQuestion() {
		return selectedQuestion;
	}

	public void setSelectedQuestion(MedQuestion selectedQuestion) {
		this.selectedQuestion = selectedQuestion;
	}
	
	public String actionSubmit(){
		return "";
	}
	
	public String returnAction(){
		return "/pages/view/carousel?faces-redirect=true";
	}

}
