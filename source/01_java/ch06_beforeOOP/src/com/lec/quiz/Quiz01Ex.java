package com.lec.quiz;

import java.util.Scanner;

//사용자로부터 수를 입력받아 절대값을 출력하는 로직을 구현하시오(단, 매개변수를 받아 절대값을 리턴하는 함수=메소드를 이용합니다 
public class Quiz01Ex {

	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.println("수를 입력하세요 :");
		su = sc.nextInt();
		System.out.println("입력하신 수의 절대값은 :" + abs(su));
		sc.close();
	}

	private static int abs(int su) {
		int result = (su >= 0) ? su : -su;
		return result;

	}
}
