package com.lec.ch02.ex1_cal;

import lombok.Data;

@Data
public class MyCalculator {
	private Calculator calculator; //MyCalculator는 Calculator을 의존하는 것을 이용 
	private int num1;
	private int num2;
	public void add() {
		calculator.addition(num1, num2);
	}
	public void sub() {
		calculator.substraction(num1, num2);
	}
	public void mul() {
		calculator.multiplication(num1, num2);
	}
	public void div() {
		calculator.division(num1, num2);
	}
	
}
