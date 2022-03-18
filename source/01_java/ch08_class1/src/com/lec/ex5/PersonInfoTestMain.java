package com.lec.ex5;

public class PersonInfoTestMain {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		PersonInfo info = new PersonInfo("È«±æµ¿", 20, 'm');
		PersonInfo info1 = new PersonInfo("±è¹Î¿ì", 24, 'm');
		PersonInfo[] person = {info, info1};
		
		for(int idx=0 ; idx<person.length; idx++) {
			person[idx].print();
		}
	}

}
