package com.lec.ex5;
//Personinfo. java & 
public class PersonInfo {
	 private String name;
	 private int age;
	 private char gender;
	 public PersonInfo() {}
	 public PersonInfo(String name, int age, char gender ) {
		 this.name = name;
		 this.age = age;
		 this.gender = gender;
	 }
	 public void print() {
		 System.out.printf("�̸�= %s\n" + "���� = %d\n" + "���� = %c\n", name, age, gender);
	 }
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
