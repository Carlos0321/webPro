package com.lec.ex3_accesss;

public class AccessMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
		System.out.println(obj.defaultMember);
		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
		obj.defaultMethod();
		obj.protectedMethod();
		obj.publicMethod();
	}

}
