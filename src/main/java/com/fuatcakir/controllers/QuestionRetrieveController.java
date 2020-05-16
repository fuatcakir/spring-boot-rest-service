package com.fuatcakir.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuatcakir.beans.QuestionDTO;
import com.fuatcakir.beans.QuestionsRegistration;

@Controller
public class QuestionRetrieveController {

	@RequestMapping(value = "/question/allquestions", method = RequestMethod.GET)

	@ResponseBody
	public List<QuestionDTO> getAllQuestions() {
		QuestionsRegistration instance = QuestionsRegistration.getInstance();
		List<QuestionDTO> questionList =instance.getQuestionList();
		return questionList;
	}

}
