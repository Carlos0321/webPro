package com.lec.ex07.friend;
// this. : 내 객체의
// this() : 현 클래스의 생성자 함수 
// super
public class Friend {
	private String name ;
	private String tell ; //"010-9999-9999" Friend f = new Friend("홍길동")
	public Friend() {
		System.out.println("매개변수 없는 생성자 함수");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("매개변수 하나짜리 생성자 함수 ");
	}
	public Friend (String name, String tell) {
		this(name) ; //Friend(name) 호출 
		this.tell = tell;
		System.out.println("매개변수 두개짜리 생성자함수");
	}
	public String infoString() {
		return "[이름]" + name + "[전화]" + tell;
	}
}
