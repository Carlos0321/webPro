package com.lec.ex08_superdot;
// super.  : �� �θ���� 
// super() : �� �θ���� ������ �Լ� 
public class ParentClass {
	private int i = 20;
	public ParentClass() {
		System.out.println("ParentClass ������");
	}
	public void method() {
		System.out.println("ParentClass�� method super���� i��" + i);
	}
	public int getI() {
		return i;
	}
	private void geti() {

	}
}