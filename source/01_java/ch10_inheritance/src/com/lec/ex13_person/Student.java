package com.lec.ex13_person;

public class Student extends Person {
	public static int i= 1;
	private String ban;
	public Student(String id, String name,String ban) {
		super(id,name);
		this.ban= ban;
		int num = i++;
		setNo("st01"+num);
	}
	@Override
	public String infoString() {
		return "(번호)" +getNo() + "\t(ID)" + getId() + "\t(이름)" +getName() +"\t(반)"+ban;
		//return super.infoString() + "\t(반)" +ban
	}
}
