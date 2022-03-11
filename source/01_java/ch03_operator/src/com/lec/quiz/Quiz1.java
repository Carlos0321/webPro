package com.lec.quiz;

import java.util.Scanner;
//사용자로부터 입력받은 수가 3의 배수인지 여부 출력

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수를 입력하세요 : ");
		int su = scanner.nextInt(); // 사용자로부터 정수 입력 받기 
		String result = su%3 == 0 ? "입력하신 수는 3의 배수입니다" : "입력하신 수는 3의배수가 아님";
		System.out.println(result);
		
	}

}
