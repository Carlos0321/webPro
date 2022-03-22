package com.lec.ex13_person;

public class Gangsa extends Person {
	public static int i =1;
	private String subject;

	public Gangsa(String id, String name,String subject) {
		super(id, name);
		this.subject = subject;
		int num = i++;
		setNo("lec" +num);
	}
	@Override
	public String infoString() {
		return "(번호)" +getNo() + "\t(ID)" + getId() + "\t(이름)" +getName() +"\t(과목)" + subject ;
	}	
}
