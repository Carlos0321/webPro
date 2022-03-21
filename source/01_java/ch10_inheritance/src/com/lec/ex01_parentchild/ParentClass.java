package com.lec.ex01_parentchild;

public class ParentClass {	
	String pStr = "부모클래스";
	public ParentClass() {
		System.out.println("부모클래스 객체 부분 생성");
	}
	public void getPapaName() {
		System.out.println("아빠이름 : 홍길동");
	}
	public void getMamaName() {
		System.out.println("엄마 이름 : 이길순");
	}
}
