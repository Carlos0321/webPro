package com.lec.ex10_customer;

public class Person {
	private String name;
	private String tel; // Person p =new Person("ȫ" , "010-9999-9999"
	public Person(String name, String tel) {
		this.name = name;
		this.tel = tel;
		
	}
	public String infoString() { // sysout(p.infoString())
		return "[�̸�]" + name + "[��ȭ]" + tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTell() {
		return tel;
	}
	public void setTell(String tell) {
		this.tel = tel;
	}
	
}
