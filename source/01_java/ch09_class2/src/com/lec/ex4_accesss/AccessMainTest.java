package com.lec.ex4_accesss;

import com.lec.ex3_accesss.AccessTest;

public class AccessMainTest {

	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
//		System.out.println(obj.privateMember);
//		System.out.println(obj.defaultMember);
//		System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
		obj.publicMethod();
//		obj.privateMethod();
//		obj.protectedMethod();
//		obj.defaultMethod();
	}

}
