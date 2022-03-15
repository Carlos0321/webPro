package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아 , 평균키를 출력 

public class Ex05_avg {

	public static void main(String[] args) {
		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 0으로 청소해야되는 이유는 ? //입력 받은 키 누적 변수
		for (int idx = 0; idx < arrName.length; idx++) {
			System.out.println(arrName[idx] + "의 키는 :");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("평균키는" + (double) totalHeight / arrName.length);
	}

}
