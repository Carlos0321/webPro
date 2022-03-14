package com.lec.condition;

public class EX05_evenOdd {

	public static void main(String[] args) {
		int num = -3;
		//if
		if(num%2 == 0) {
			System.out.println("Â¦¼ö");
		}else {
			System.out.println("È¦¼ö");
	}
		//switch
		switch(num%2) {
		case 0 : System.out.println("Â¦¼ö");  break;
		default : System.out.println("È¦¼ö"); break;
		}
		//»ïÇ×¿¬»êÀÚ
		System.out.println(num%2==0 ? "Â¦¼ö" : "È¦¼ö");
}
}