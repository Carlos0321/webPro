package com.lec.Quiz;

public class Quiz04 {

	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		for(int i =0 ; i < coinUnit.length; i++) {
		 System.out.println(coinUnit[i] + "원짜리 동전" + (money/coinUnit[i])+ "개");
		 money %= coinUnit[i];
		}
		
	}

}
