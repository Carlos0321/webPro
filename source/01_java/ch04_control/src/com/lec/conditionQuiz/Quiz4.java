package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("가위(0), 바위(1), 보(2) 중 하나를 선택하세요 : ");
	int you = sc.nextInt() ;
	if(you == 0) {
		System.out.println("너는 가위를 냈어");
	}else if (you == 1) {
		System.out.println("너는 바위를 냈어");
	}else if(you == 2){
		System.out.println("너는 보자기를 냈어");
	}else {
		System.out.println("유효하지 않는 값입니다");
		
	}
	sc.close();
	}
	


}
