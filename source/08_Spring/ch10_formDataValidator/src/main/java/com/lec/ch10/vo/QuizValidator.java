package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class QuizValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Quiz.class.isAssignableFrom(clazz); //검증할 객체의 클래스 타입 명시
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("v1");
		Quiz quiz = (Quiz)target;
		System.out.println("v2");
		String name = quiz.getName();
		System.out.println("v3");
		int kor = quiz.getKor();
		System.out.println("v4");
		int eng = quiz.getEng();
		System.out.println("v5");
		int mat = quiz.getMat();
		System.out.println("v6");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","no");
		if(name.trim().isEmpty()) {
			errors.rejectValue("name", "이름 필수"); 
			System.out.println("v7");
		}
		
		if(kor<=0 || kor>=100) {
			errors.rejectValue("kor", "점수는 0~100점 사이");
			System.out.println("v8");
		}
		
		if(eng<=0 || eng>=100) {
			errors.rejectValue("eng", "점수는 0~100점 사이");
			System.out.println("v9");
		}
		
		if(mat<=0 || mat>=100) {
			errors.rejectValue("mat", "점수는 0~100점 사이");
			System.out.println("v10");
		}
		
	}

}
