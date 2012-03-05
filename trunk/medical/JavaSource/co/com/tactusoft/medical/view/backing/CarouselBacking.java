package co.com.tactusoft.medical.view.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedTopic;

@Named
@Scope("session")
public class CarouselBacking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AdminBo service;

	private List<MedTopic> list = new ArrayList<MedTopic>();
	private MedTopic selectedMenu;

	public CarouselBacking() {
		list = new ArrayList<MedTopic>();
	}

	public List<MedTopic> getList() {
		if(list.size() ==0){
			list=service.getListMedTopic();
		}
		return list;
	}

	public void setList(List<MedTopic> list) {
		this.list = list;
	}

	public MedTopic getSelectedMenu() {
		return selectedMenu;
	}

	public void setSelectedMenu(MedTopic selectedMenu) {
		this.selectedMenu = selectedMenu;
	} 

	public String generateQuestions() {
		/*QuestionBacking questionBacking = FaceUtils.findBean("questionBacking");
		switch (selectedMenu.getId()) {
		case 1:
			List<Question> list = new ArrayList<Question>();

			Question question = new Question();
			question.setId(1);
			question.setName("Hace menos de una semana que ha tenido un hijo");
			question.setPositive(2);
			question.setNegative(3);
			list.add(question);

			question = new Question();
			question.setId(2);
			question.setName("La DEPRESIÓN AL TERCER DÍA es el nombre mas común para este sentimiento de tristeza y depresión"
					+ " que afecta a muchas mujeres en los 7 días siguientes al parto");
			question.setFinalQuestion(1);
			question.setUrl("http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto");
			list.add(question);

			question = new Question();
			question.setId(3);
			question.setName("Se siente bien la mayor parte del tiempo pero a veces se siente deprimida e irritable");
			question.setPositive(4);
			question.setNegative(5);
			list.add(question);

			question = new Question();
			question.setId(4);
			question.setName("Los periodos de DEPRESION e IRRITABILIDAD son comunes en los meses siguientes al nacimiento del niño. "
					+ "Al mismo tiempo que se ve afectada por los cambios hormonales y pósibles sentimientos contradictorios, "
					+ " también es posible que se encuentre cansada y preocupada por su responsabilidad maternal o por el desarrollo general del niño");
			question.setFinalQuestion(1);
			question.setUrl("http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto");
			list.add(question);

			question = new Question();
			question.setId(5);
			question.setName("La DEPRESIÓN POSTPARTO es un problema que afecta madres primerizas en los primeros 6 meses después del parto");
			question.setFinalQuestion(1);
			question.setUrl("http://es.wikipedia.org/wiki/Depresi%C3%B3n_postparto");
			list.add(question);

			questionBacking.setListQuestion(list);
			questionBacking.setSelectedQuestion(list.get(0));

			break;
		case 2:
		case 3:
		case 4:
		case 5:
			Question selectedQuestion = new Question();
			selectedQuestion.setId(-1);
			selectedQuestion
					.setName("No existe información. Contacte al Administrador");
			selectedQuestion.setFinalQuestion(1);

			questionBacking.setSelectedQuestion(selectedQuestion);
			break;

		}*/
		return "GO_QUESTION";
	}

}
