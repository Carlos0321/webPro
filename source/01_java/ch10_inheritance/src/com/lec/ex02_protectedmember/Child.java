package com.lec.ex02_protectedmember;

public class Child extends SuperIJ{
	private int total ;

	public Child() {
		System.out.println("매개변수 없는 Child(생성자) 함수");
	}
	//Child c = new Child(10, 20);
	public  Child(int i, int j) {
		setI(i); //this.i =i;
		setJ(j); 
		System.out.println("매개변수 있는 Child생성자");
	}
	public void sum() {
		total = getI() + getJ();
		System.out.printf("본 객체의 i = %d, j = %d" , getI(),getJ());
		System.out.printf("\n본 객체의 total = %d", total);
		
	}
	
}
