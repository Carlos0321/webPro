package com.lec.ex08_superdot;
//super.  : 내 부모단의 
//super() : 내 부모단의 생성자 함수 
public class ChildClass extends ParentClass{ //ParentClass - i , method
	private int i = 99;
	
	public ChildClass () {
		System.out.println("ChildClass 생성자");
	}

	@Override
	public void method() {
		System.out.println("ChildClass의 method");
		super.method();
		System.out.println("ChildClass에서 super의 i = " +super.getI()+",Child단의 i =" +i);
	}

	@Override
	public int getI() {
		return i;
	}
	
	}

