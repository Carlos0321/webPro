package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{
	private int total ;

	public Child() {
		System.out.println("�Ű����� ���� Child(������) �Լ�");
	}
	//Child c = new Child(10, 20);
	public  Child(int i, int j) {
		setI(i); //this.i =i;
		setJ(j); 
		System.out.println("�Ű����� �ִ� Child������");
	}
	public void sum() {
		total = getI() + getJ();
		System.out.printf("�� ��ü�� i = %d, j = %d" , getI(),getJ());
		System.out.printf("\n�� ��ü�� total = %d", total);
		
	}
	
}
