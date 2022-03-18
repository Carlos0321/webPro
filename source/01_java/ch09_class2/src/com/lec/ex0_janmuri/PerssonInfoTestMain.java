package com.lec.ex0_janmuri;
class PersonInfo{
	private String name;
	private int age;
	public PersonInfo(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void print() {
		System.out.printf("이름 = %s\n나이 = %d\n", name,age);
	}
}
public class PerssonInfoTestMain {

	public static void main(String[] args) {
		PersonInfo[] person = {new PersonInfo("홍길동", 22),
							 	new PersonInfo("신길동", 33)};
		for(PersonInfo p : person) {
			p.print();
		}
		for(int idx=0; idx < person.length ; idx++) {
			person[idx].print();
		}
	}

}
