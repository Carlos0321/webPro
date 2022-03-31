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
		return "이름 "+ name + "\t전화번호 " +  tel ; 
	}
	
}
