package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수  :");
		int kor = sc.nextInt() ;
		
		System.out.println("영어 점수 :");
		int eng = sc.nextInt();
		
		System.out.println("수학 점수 : ");
		int math = sc.nextInt();
		
	    
		double avg = (kor + eng + math) /3 ;
		System.out.printf("평균은 %.2f점\n", avg);
	 if(avg >= kor){
		System.out.println("국어점수가 평균 이상 ");
		
	}else if(avg <= kor){
		System.out.println("국어점수가 평균 이하");
	}
	if(avg >= eng) {
		System.out.println("영어점수가 평균이상");
		
	}else if(avg <= eng) {
		System.out.println("영어점수가 평균이하");
	}
		if(avg >= math) {
		System.out.println("수학점수가 평균 이상");
	}else if(avg <= math) {
		System.out.println("수학점수가 평균 이하");
	}
		sc.close();
	}
}
	
	
	
