package com.lec.ex13_person;

public class Staff extends Person {
	public static int j = 1;
	private String department;
	
	public Staff(String id, String name, String department) {
		super(id, name);
		this.department = department;
		int num = j++;
		setNo("staff"+num);
	}
	@Override
	public String infoString() {
		return "(��ȣ)" +getNo() + "\t(ID)" + getId() + "\t(�̸�)" +getName()+"\t(�μ�)"+department;
	}
}
