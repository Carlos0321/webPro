package com.lec.ch10.vo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz); //검증할 객체의 클래스 타입 명시
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 컨트롤러에서 호출 : validator(student,errors)호출
		Student student = (Student)target;
		String name = student.getName();
		int id = student.getId();
		/*
		 * if(name==null || name.trim().isEmpty()) { //name 에러
		 * errors.rejectValue("name", "no"); //name 에러 등록 }
		 */
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "no");//name 에러 등록
		 if(id<=0){
			errors.rejectValue("id", "no"); //id 에러 등록
		}
	}

}
