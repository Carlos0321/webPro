package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하시오 : ");
		int su = sc.nextInt();
		if(su>=0) {
			System.out.printf("입력하신 수의 절대값은 %d, su", su);
		}else {
			System.out.printf("입력하신 수의 절대값은 %d, -su", -su);
		}
	
	sc.close();
	}
}