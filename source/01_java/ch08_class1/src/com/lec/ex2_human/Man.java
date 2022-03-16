package com.lec.ex2_human;
// man kim = new Man(22, 160, 50.5, "010-9999-9999);

//man kim = new Man(22, 160, 50.5, "010-9999-9999);

public class Man {
	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	public Man () {} //디폴트 생성자 함수 
	public Man(int age) {
		this.age =age;
	}
//		if(age < 100) {
//			
//		}else {
//			height = age;
//		}
//		this.age =age ;
	
//	public Man (int height) {
//		this.height = height;
//	}

	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		System.out.println("파라미터가 3개짜리 생성자 함수 호출");
	}

	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
		System.out.println("파라미터가 4개짜리 생성자 함수 호출");
	}
}