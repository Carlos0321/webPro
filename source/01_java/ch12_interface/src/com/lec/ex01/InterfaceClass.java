package com.lec.ex01;

// CONSTANT_NUM, CONSTANTSTRING, method1(�߻�) ,method2(�߻�)
public class InterfaceClass implements InterfaceEx1, InterfaceEx2 {

	@Override
	public String method2() {
		System.out.println("���� ������ implements�� Ŭ�������� �ؿ�. method2");
		return null;
	}

	@Override
	public void method1() {
		System.out.println("���� ������ implements ���� Ŭ�������� �ؿ�. method1");
	}

}