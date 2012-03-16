package co.com.tactusoft.medical.view.backing;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;

import co.com.tactusoft.medical.controller.bo.AdminBo;
import co.com.tactusoft.medical.model.entities.MedAnswer;
import co.com.tactusoft.medical.model.entities.MedCombination;
import co.com.tactusoft.medical.model.entities.MedQuestion;
import co.com.tactusoft.medical.util.Constant;
import co.com.tactusoft.medical.util.FacesUtil;
import co.com.tactusoft.medical.view.datamodel.AnswerDataModel;
import co.com.tactusoft.medical.view.datamodel.Combination;
import co.com.tactusoft.medical.view.datamodel.CombinationDataModel;
import co.com.tactusoft.medical.view.datamodel.QuestionDataModel;

@Named
@Scope("session")
public class QuestionBacking {

	@Inject
	private AdminBo service;

	private MedQuestion selected;
	private BigDecimal idTopic;

	private BigDecimal positiveQuestion;
	private BigDecimal negativeQuestion;

	private List<SelectItem> listQuestion;
	private Map<BigDecimal, MedQuestion> mapQuestion;

	private int orderQuestion;

	private String currentResourceType;
	private Boolean currnetOnLineResource;
	private Boolean newFile;
	private String typeFinal;
	private UploadedFile file;
	private String urlImages;

	private List<MedAnswer> listAnswer;
	private MedAnswer[] selectedsAnswer;
	private List<MedAnswer> selectedDeletesAnswer;
	private String answerText;
	private AnswerDataModel modelAnswer;
	private List<SelectItem> listAnswerMultiple;
	private Map<BigDecimal, MedAnswer> mapAnwserMultiple;
	private BigDecimal nextQuestionMultiple;
	private BigDecimal[] selectedsCombination;
	private List<MedCombination> listMedCombination;
	private List<Combination> listCombination;
	private CombinationDataModel modelCombination;
	private Combination selectedCombination;

	public QuestionBacking() {
	}

	public void init(MedQuestion selected) {
		idTopic = selected.getMedTopic().getId();

		List<MedQuestion> list = null;
		listQuestion = new LinkedList<SelectItem>();
		mapQuestion = new HashMap<BigDecimal, MedQuestion>();
		listAnswer = new LinkedList<MedAnswer>();
		modelAnswer = new AnswerDataModel(listAnswer);
		answerText = null;
		selectedDeletesAnswer = new LinkedList<MedAnswer>();
		listAnswerMultiple = new LinkedList<SelectItem>();
		mapAnwserMultiple = new HashMap<BigDecimal, MedAnswer>();

		listMedCombination = new LinkedList<MedCombination>();
		listCombination = new LinkedList<Combination>();
		modelCombination = new CombinationDataModel(listCombination);

		listQuestion.add(new SelectItem(Constant.DEFAULT_VALUE,
				Constant.DEFAULT_LABEL));

		if (selected.getId() != null) {
			list = service.getListMedQuestionByNoIdQuestion(selected.getId(),
					idTopic);
		} else {
			list = service.getListMedQuestionByTopic(idTopic);
			if (list.size() > 0) {
				orderQuestion = list.get(list.size() - 1).getOrderQuestion() + 1;
			} else {
				orderQuestion = 1;
			}
			selected.setOrderQuestion(orderQuestion);
		}

		for (MedQuestion row : list) {
			String question = row.getName();
			if (question.length() > 60) {
				question = question.substring(0, 60) + "...";
			}
			listQuestion.add(new SelectItem(row.getId(), question));
			mapQuestion.put(row.getId(), row);
		}

		this.selected = selected;
		this.currentResourceType = selected.getResourceType() == null ? " "
				: selected.getResourceType();
		this.currnetOnLineResource = selected.isImageVideoONLINE();
		this.newFile = false;
		searchQuestionAction();
	}

	public MedQuestion getSelected() {
		return selected;
	}

	public void setSelected(MedQuestion selected) {
		this.selected = selected;
	}

	public BigDecimal getPositiveQuestion() {
		return positiveQuestion;
	}

	public void setPositiveQuestion(BigDecimal positiveQuestion) {
		this.positiveQuestion = positiveQuestion;
	}

	public BigDecimal getNegativeQuestion() {
		return negativeQuestion;
	}

	public void setNegativeQuestion(BigDecimal negativeQuestion) {
		this.negativeQuestion = negativeQuestion;
	}

	public List<SelectItem> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<SelectItem> listQuestion) {
		this.listQuestion = listQuestion;
	}

	public String getTypeFinal() {
		return typeFinal;
	}

	public void setTypeFinal(String typeFinal) {
		this.typeFinal = typeFinal;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getUrlImages() {
		ParameterBacking parameterBacking = FacesUtil
				.findBean("parameterBacking");
		urlImages = parameterBacking.getUrlImages();
		return urlImages;
	}

	public void setUrlImages(String urlImages) {
		this.urlImages = urlImages;
	}

	public List<MedAnswer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<MedAnswer> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public MedAnswer[] getSelectedsAnswer() {
		return selectedsAnswer;
	}

	public void setSelectedsAnswer(MedAnswer[] selectedsAnswer) {
		this.selectedsAnswer = selectedsAnswer;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public AnswerDataModel getModelAnswer() {
		return modelAnswer;
	}

	public void setModelAnswer(AnswerDataModel modelAnswer) {
		this.modelAnswer = modelAnswer;
	}

	public List<SelectItem> getListAnswerMultiple() {
		return listAnswerMultiple;
	}

	public void setListAnswerMultiple(List<SelectItem> listAnswerMultiple) {
		this.listAnswerMultiple = listAnswerMultiple;
	}

	public BigDecimal getNextQuestionMultiple() {
		return nextQuestionMultiple;
	}

	public void setNextQuestionMultiple(BigDecimal nextQuestionMultiple) {
		this.nextQuestionMultiple = nextQuestionMultiple;
	}

	public BigDecimal[] getSelectedsCombination() {
		return selectedsCombination;
	}

	public void setSelectedsCombination(BigDecimal[] selectedsCombination) {
		this.selectedsCombination = selectedsCombination;
	}

	public List<MedCombination> getListMedCombination() {
		return listMedCombination;
	}

	public void setListMedCombination(List<MedCombination> listMedCombination) {
		this.listMedCombination = listMedCombination;
	}

	public CombinationDataModel getModelCombination() {
		return modelCombination;
	}

	public void setModelCombination(CombinationDataModel modelCombination) {
		this.modelCombination = modelCombination;
	}

	public Combination getSelectedCombination() {
		return selectedCombination;
	}

	public void setSelectedCombination(Combination selectedCombination) {
		this.selectedCombination = selectedCombination;
	}

	public void searchQuestionAction() {
		if (selected.getId() != null) {
			if (selected.getTypeQuestion().equals(
					Constant.QUESTION_TYPE_ASSERTIVE)) {

			} else if (selected.getTypeQuestion().equals(
					Constant.QUESTION_TYPE_UNIQUE)) {
				listAnswer = service.getListMedQuestionByQuestion(selected
						.getId());
				modelAnswer = new AnswerDataModel(listAnswer);
			} else if (selected.getTypeQuestion().equals(
					Constant.QUESTION_TYPE_MULTIPLE)) {

				listAnswer = service.getListMedQuestionByQuestion(selected
						.getId());
				modelAnswer = new AnswerDataModel(listAnswer);

				for (MedAnswer row : listAnswer) {
					String substr = row.getName();
					if (substr.length() > 60) {
						substr = substr.substring(0, 60) + "...";
					}
					listAnswerMultiple.add(new SelectItem(row.getId(), substr));
					mapAnwserMultiple.put(row.getId(), row);
				}

				listMedCombination = service
						.getListMedCombinationByQuestion(selected.getId());
				listCombination = getLisCombination(listMedCombination);
				modelCombination = new CombinationDataModel(listCombination);

			} else if (selected.getTypeQuestion().equals(
					Constant.QUESTION_TYPE_MEDIA)) {

				if (!selected.getResourceType().equals(
						Constant.RESOURCE_TYPE_VIDEO)
						&& !selected.getResourceType().equals(
								Constant.RESOURCE_TYPE_IMAGE)) {
					selected.setLoadMode(Constant.LOAD_MODE_ON_LINE);
				}
			}
		} else {
			selected.setTypeQuestion(Constant.QUESTION_TYPE_MESSAGE);
			selected.setPositive(Constant.DEFAULT_VALUE);
			selected.setNegative(Constant.DEFAULT_VALUE);
			selected.setResourceType(Constant.RESOURCE_TYPE_IMAGE);
			selected.setLoadMode(Constant.LOAD_MODE_ON_LINE);
		}
	}

	public void saveAction() {
		String message = null;
		try {
			String field = null;
			boolean newRecord = false;

			if (selected.getId() == null) {
				selected.setId(service.getId("MedQuestion"));
				newRecord = true;
			}

			if (selected.getTypeQuestion().equals(Constant.QUESTION_TYPE_MEDIA)
					&& selected.getResourceType() != null) {

				if (selected.getResourceType().equals(
						Constant.RESOURCE_TYPE_IMAGE)
						|| selected.getResourceType().equals(
								Constant.RESOURCE_TYPE_VIDEO)) {

					if (!selected.isImageVideoONLINE()) {
						if (file == null && selected.getImage() == null) {
							field = FacesUtil.getMessage("que_type_final_file");
							message = FacesUtil.getMessage(
									"msg_field_required", field);
						} else {
							try {

								if (!currentResourceType.equals(selected
										.getResourceType())
										|| (currnetOnLineResource && (!selected
												.isImageVideoONLINE()))
										|| newFile) {

									ParameterBacking parameterBacking = FacesUtil
											.findBean("parameterBacking");
									String directory = parameterBacking
											.getDirectory();
									String ext = FacesUtil
											.getExtensionFile(file
													.getFileName());
									String fileName = "question"
											+ selected.getId() + ext;
									FacesUtil.createFile(file.getInputstream(),
											directory + fileName);

									selected.setImage(fileName);

									this.currentResourceType = selected
											.getResourceType();
									this.currnetOnLineResource = selected
											.isImageVideoONLINE();
									this.newFile = false;

									Pattern patternWindows = Pattern
											.compile("([^\\s]+(\\.(?i)(asx|asf|avi|wma|wmv))$)");
									Pattern patternQuicktime = Pattern
											.compile("([^\\s]+(\\.(?i)(aif|aiff|aac|au|bmp|gsm|mov|mid|midi|mpg|mpeg|mp4|m4a|psd|qt|qtif|qif|qti|snd|tif|tiff|wav|3g2|3pg))$)");
									Pattern patternFlash = Pattern
											.compile("([^\\s]+(\\.(?i)(flv|mp3|swf))$)");
									Pattern patternReal = Pattern
											.compile("([^\\s]+(\\.(?i)(ra|ram|rm|rpm|rv|smi|smil))$)");

									if (patternWindows.matcher(fileName)
											.matches()) {
										this.selected
												.setTypeVideo(Constant.VIDEO_TYPE_WINDOWS);
									} else if (patternQuicktime.matcher(
											fileName).matches()) {
										this.selected
												.setTypeVideo(Constant.VIDEO_TYPE_QUICKTIME);
									} else if (patternFlash.matcher(fileName)
											.matches()) {
										this.selected
												.setTypeVideo(Constant.VIDEO_TYPE_FLASH);
									} else if (patternReal.matcher(fileName)
											.matches()) {
										this.selected
												.setTypeVideo(Constant.VIDEO_TYPE_REAL);
									}
								}

							} catch (NullPointerException ex) {
								field = FacesUtil
										.getMessage("que_type_final_file");
								message = FacesUtil.getMessage(
										"msg_field_required", field);
							}
						}

						selected.setUrlLink(null);

						if (selected.getResourceType().equals(
								Constant.RESOURCE_TYPE_IMAGE)) {
							selected.setTypeVideo(null);
						}

					} else {
						if (selected.getUrlLink() == null
								|| selected.getUrlLink().equals("")) {
							field = FacesUtil.getMessage("que_type_final_url");
							message = FacesUtil.getMessage(
									"msg_field_required", field);
						}
						selected.setImage(null);
					}

				} else {
					selected.setImage(null);
				}
			} else if (selected.getTypeQuestion().equals(
					Constant.QUESTION_TYPE_UNIQUE)
					|| selected.getTypeQuestion().equals(
							Constant.QUESTION_TYPE_MULTIPLE)) {
				if (listAnswer.size() == 0) {
					message = FacesUtil
							.getMessage("que_msg_validate_nextquestion");
				} else {
					if (selected.getTypeQuestion().equals(
							Constant.QUESTION_TYPE_UNIQUE)) {
						for (MedAnswer row : listAnswer) {
							if (row.getNextQuestion().intValue() == -1) {
								message = FacesUtil
										.getMessage("que_msg_validate_nextquestion");
								break;
							}
						}
					}
				}
			}

			if (message == null) {

				if (!selected.getTypeQuestion().equals(
						Constant.QUESTION_TYPE_MEDIA)) {
					this.selected.setImage(null);
					this.selected.setLoadMode(null);
					this.selected.setTypeVideo(null);
					this.selected.setResourceType(null);
				}

				service.save(selected);

				if (newRecord) {
					message = FacesUtil.getMessage("msg_record_ok_3");
				} else {
					message = FacesUtil.getMessage("msg_record_ok_2");
				}

				if (!selected.getTypeQuestion().equals(
						Constant.QUESTION_TYPE_UNIQUE)
						&& !selected.getTypeQuestion().equals(
								Constant.QUESTION_TYPE_MULTIPLE)) {

					for (MedAnswer row : listAnswer) {
						service.remove(row);
					}

					listAnswer = new LinkedList<MedAnswer>();
					modelAnswer = new AnswerDataModel(listAnswer);

					listMedCombination = new LinkedList<MedCombination>();
					/*
					 * modelCombination = new CombinationDataModel(
					 * listMedCombination);
					 */

				} else {
					for (MedAnswer row : listAnswer) {
						if (row.getId() == null) {
							row.setId(service.getId("MedAnswer"));
						}
						service.save(row);
					}

					for (MedAnswer row : selectedDeletesAnswer) {
						service.remove(row);
					}

					for (MedCombination row : listMedCombination) {
						if (row.getId() == null) {
							row.setId(service.getId("MedCombination"));
						}
						service.save(row);
					}
				}

				FacesUtil.addInfo(message);

				TopicBacking topicBacking = FacesUtil.findBean("topicBacking");
				QuestionDataModel questionDataModel = new QuestionDataModel(
						service.getListMedQuestionByTopic(idTopic));
				topicBacking.setModelQuestion(questionDataModel);
			} else {
				FacesUtil.addWarn(message);
			}
		} catch (IOException EX) {
			message = FacesUtil.getMessage("msg_file_error");
			FacesUtil.addError(message);
		}
	}

	public String goTopicAction() {
		return "/pages/admin/topic?faces-redirect=true";
	}

	public void handleFileUpload(FileUploadEvent event) {
		newFile = true;
		file = event.getFile();
	}

	public void addAnswerAction() {
		if (answerText.length() == 0) {
			String field = FacesUtil.getMessage("que_answer");
			String message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			MedAnswer selectedAnswer = new MedAnswer();
			selectedAnswer.setMedQuestion(selected);
			selectedAnswer.setName(answerText);
			selectedAnswer.setNextQuestion(Constant.DEFAULT_VALUE);
			listAnswer.add(selectedAnswer);
			modelAnswer = new AnswerDataModel(listAnswer);

			/*
			 * listAnswerMultiple.add(new SelectItem(selectedAnswer.getId(),
			 * selectedAnswer.getName()));
			 * mapAnwserMultiple.put(selectedAnswer.getId(), selectedAnswer);
			 */

			answerText = "";
			selectedsCombination = null;
		}
	}

	public void addCombinationAction() {
		String field = null;
		String message = null;
		if (selectedsCombination == null) {
			field = FacesUtil.getMessage("que_answers");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else if (nextQuestionMultiple.intValue() == -1) {
			field = FacesUtil.getMessage("que_answer");
			message = FacesUtil.getMessage("msg_field_required", field);
			FacesUtil.addWarn(message);
		} else {
			MedQuestion mqm = mapQuestion.get(nextQuestionMultiple);
			String answers = "";

			for (BigDecimal id : selectedsCombination) {
				answers = answers + id + "+";
			}
			
			answers = answers.substring(0, answers.length() - 1);

			MedCombination medCombination = new MedCombination();
			medCombination.setMedQuestionByIdQuestion(selected);
			medCombination.setAnswers(answers);
			medCombination.setMedQuestionByNextQuestion(mqm);
			listMedCombination.add(medCombination);
			
			listCombination = getLisCombination(listMedCombination);
			modelCombination = new CombinationDataModel(listCombination);
			nextQuestionMultiple = Constant.DEFAULT_VALUE;
			selectedsCombination = null;
		}
	}

	public void changeAnswerTypeAction() {
		if (selected.getTypeQuestion().equals(Constant.QUESTION_TYPE_ASSERTIVE)) {

		} else if (selected.getTypeQuestion().equals(
				Constant.QUESTION_TYPE_UNIQUE)) {
		} else if (selected.getTypeQuestion().equals(
				Constant.QUESTION_TYPE_MULTIPLE)) {
		} else if (selected.getTypeQuestion().equals(
				Constant.QUESTION_TYPE_MEDIA)) {
		}
	}

	public void removeAnswerAction() {
		selectedDeletesAnswer = new LinkedList<MedAnswer>();
		for (MedAnswer row : selectedsAnswer) {
			listAnswer.remove(row);
			selectedDeletesAnswer.add(row);
		}
		modelAnswer = new AnswerDataModel(listAnswer);
	}

	public int getSize() {
		return listAnswer.size();
	}

	private List<Combination> getLisCombination(List<MedCombination> list) {
		List<Combination> result = new LinkedList<Combination>();
		for (MedCombination row : list) {
			Combination obj = new Combination();
			obj.setId(row.getId());
			obj.setNextQuestion(row.getMedQuestionByNextQuestion());
			List<MedAnswer> listAnswers = new LinkedList<MedAnswer>();
			StringTokenizer answers = new StringTokenizer(row.getAnswers(),"+");
			while (answers.hasMoreTokens()) {
				String answer = answers.nextToken();
				BigDecimal id = new BigDecimal(answer);
				MedAnswer medAnswer = mapAnwserMultiple.get(id);
				listAnswers.add(medAnswer);
			}
			obj.setListAnswers(listAnswers);
			result.add(obj);
		}
		return result;
	}
	
	public void deleteCombination(){
		BigDecimal id = new BigDecimal(FacesUtil.getParam("COMBINATION_ID"));
		System.out.println(id);
	}

}