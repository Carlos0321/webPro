package com.lec.ch10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch10.vo.Quiz;
import com.lec.ch10.vo.QuizValidator;

@Controller
public class QuizController {
	@ModelAttribute("cnt")
	public String cnt() {
		return "현재 총 4명";
	}
	@RequestMapping(value = "quizInput.do", method = RequestMethod.GET)
	public String quizinput() {
		return "quiz/quizinput";
	}

	@RequestMapping(value = "quizInput.do", method = RequestMethod.POST)
	public String input(Quiz quiz, Errors errors, Model model) {
		QuizValidator validator = new QuizValidator();
		System.out.println(1);
		validator.validate(quiz, errors);
		System.out.println(2);
		if (errors.hasErrors()) {
			System.out.println(3);
			if (errors.getFieldError("name") != null) {
				model.addAttribute("nameError", "name은 필수 입력 사항");
			}
			System.out.println(4);
			if (errors.getFieldError("kor") != null || ("eng") != null || ("mat") !=null) {
				model.addAttribute("kor", "점수 필수 입력 사항");
			}
			System.out.println(5);
			return "quiz/quizinput";
		}
		System.out.println(6);
		return "quiz/quizResult";
	}
}
