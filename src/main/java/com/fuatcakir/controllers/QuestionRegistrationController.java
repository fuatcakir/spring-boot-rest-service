package com.fuatcakir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fuatcakir.beans.QuestionDTO;
import com.fuatcakir.beans.QuestionRegistrationReply;
import com.fuatcakir.beans.QuestionsRegistration;

@Controller
public class QuestionRegistrationController {
	@RequestMapping(value = "/question/registration", method = RequestMethod.POST)

	@ResponseBody
	public QuestionRegistrationReply saveQuestion(@RequestBody QuestionDTO questionDTO) {
		System.out.println("In registerQuestion");
		QuestionRegistrationReply questionRegistrationReply = new QuestionRegistrationReply();
		String message = QuestionsRegistration.getInstance().save(questionDTO);
		questionRegistrationReply.setQuestionDTO(questionDTO);
		questionRegistrationReply.setRegistrationStatus(message);
		return questionRegistrationReply;
	}

}
