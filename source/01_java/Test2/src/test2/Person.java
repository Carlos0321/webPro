package test2;

public class Person {
	private String name;
	private String tel;
	
	public Person() {}

	public Person(String name, String tel) {
		
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "�̸� "+ name + "\t��ȭ��ȣ " +  tel ; 
	}
	
}
