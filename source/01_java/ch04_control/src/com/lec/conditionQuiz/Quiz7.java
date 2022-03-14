package com.lec.conditionQuiz;

import java.util.Scanner;

//사용자로부터 개월수를 받는다 
public class Quiz7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("현재 몇월입니까?");
		int month = sc.nextInt();
		switch(month) {
		case 12: case 1 : case 2:
			System.out.println("겨울이네요"); break;
		case 3: case 4: case 5 :
			System.out.println("봄이네요"); break;
		case 6: case 7: case 8:
			System.out.println("여름이네요"); break;
		case 9 : case 10: case 11:
			System.out.println("가을이네요"); break;
		default :
			System.out.println("잘못됨");
		}
	}

}
