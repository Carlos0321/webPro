package com.lec.ex4_object;
// 9512121025252

public class Person {
	private long juminNo;

	public Person(long juminNo) {
		this.juminNo = juminNo;
	}

	@Override
	public String toString() {
		return "Person [juminNo=" + juminNo + "]";
	} 
	@Override
	public boolean equals(Object obj) { 
		//p1.equals(p2)호출할 경우 p1대신 this, p2대신 obj =>내 객체의 juminNo와 obj.juminNo가 같은지 여부를 return
		//p1.equals(p3)호출할 경우 p3대신 obj => false를 return
		if(obj !=null && obj instanceof Person){ //obj가 Person 타입의 객체
			return juminNo == ((Person)obj).juminNo;
		}else {
			return false;
		}
	}
}
