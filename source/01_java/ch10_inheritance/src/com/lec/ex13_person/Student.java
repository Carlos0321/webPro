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
		return "(��ȣ)" +getNo() + "\t(ID)" + getId() + "\t(�̸�)" +getName() +"\t(��)"+ban;
		//return super.infoString() + "\t(��)" +ban
	}
}
