package com.lec.condition;

public class EX05_evenOdd {

	public static void main(String[] args) {
		int num = -3;
		//if
		if(num%2 == 0) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
	}
		//switch
		switch(num%2) {
		case 0 : System.out.println("¦��");  break;
		default : System.out.println("Ȧ��"); break;
		}
		//���׿�����
		System.out.println(num%2==0 ? "¦��" : "Ȧ��");
}
}