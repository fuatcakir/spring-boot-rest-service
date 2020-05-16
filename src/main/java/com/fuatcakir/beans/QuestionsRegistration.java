package com.fuatcakir.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class QuestionsRegistration {

	private List<QuestionDTO> questionList;

	private static QuestionsRegistration questionsRegistration;

	private QuestionsRegistration() {
		questionList = new ArrayList<QuestionDTO>();
	}

	public static QuestionsRegistration getInstance() {
		if (questionsRegistration == null) {
			questionsRegistration = new QuestionsRegistration();
			return questionsRegistration;
		} else {
			return questionsRegistration;
		}
	}

	public void add(QuestionDTO questionDTO) {
		getQuestionList().add(questionDTO);
	}

	public String update(QuestionDTO questionDTO) {
		for (int i = 0; i < getQuestionList().size(); i++) {
			QuestionDTO questionStore = getQuestionList().get(i);
			if (questionStore.getSeqNo() == questionDTO.getSeqNo()) {
				getQuestionList().set(i, questionDTO);
				return "Updated succesful";
			}
		}
		return "Updated un-succesful";
	}

	public String save(QuestionDTO questionDTO) {
		Boolean questionUpdated = Boolean.FALSE;
		String msg = validation(questionDTO);

		if (StringUtils.isEmpty(msg)) {

			for (int i = 0; i < getQuestionList().size(); i++) {
				QuestionDTO questionStore = getQuestionList().get(i);
				if (questionStore.getSeqNo() == questionDTO.getSeqNo()) {
					getQuestionList().set(i, questionDTO);
					msg = "Updated succesful";
					questionUpdated = Boolean.TRUE;
				}
			}
			if (!questionUpdated) {
				getQuestionList().add(questionDTO);
				msg = "Added succesful";
			}
		}
		return msg;
	}

	private String validation(QuestionDTO questionDTO) {
		String msg = "";
		if (questionDTO == null) {
			msg = "questionDTO required!";
		}
		if (StringUtils.isEmpty(questionDTO.getQuestion())) {
			msg = "questionDTO required!";
		}
		if (StringUtils.isEmpty(questionDTO.getAnswer())) {
			msg = "questionDTO required!";
		}
		return msg;
	}

	public String delete(QuestionDTO questionDTO) {
		for (int i = 0; i < getQuestionList().size(); i++) {
			QuestionDTO questionStore = getQuestionList().get(i);
			if (questionStore.getSeqNo() == questionDTO.getSeqNo()) {
				getQuestionList().remove(i);
				return "Remeved succesful";
			}
		}
		return "Remeved un-succesful";
	}

	public List<QuestionDTO> getQuestionList() {
		return questionList;
	}

}
