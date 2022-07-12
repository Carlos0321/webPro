package com.lec.ch02.ex5_exam;

import lombok.Data;

@Data
public class IExam implements Exam {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int com;
	
	public int total() {
		return kor+eng+mat+com;
	}

	public double avg() {
		return total()/4.0;
	}

}
