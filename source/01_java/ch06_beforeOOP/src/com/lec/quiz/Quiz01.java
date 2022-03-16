package com.lec.quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		int su ;
		Scanner sc  = new Scanner(System.in);
		do {
			System.out.print("원하는 단수를 입력하시오 :");
			su = sc.nextInt();
			if(su <2 || su>9) {
				System.out.println("땡 다시입력하세요 : ");
			}
		}while(su <2 || su>9);
		dansu(su);  // 메소드(함수)를 설정하여 호출 
		sc.close();
	}
	private static void dansu(int su) {  //메소드 정의내리기
		for(int i=1 ; i<10 ; i++) {
			System.out.println(su + "*" +i+ " = " +su*i);
		}
	}
}
