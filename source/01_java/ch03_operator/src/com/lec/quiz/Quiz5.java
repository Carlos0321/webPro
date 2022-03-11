package com.lec.quiz;

import java.util.Scanner;

// 국어, 영어, 수학, 점수를 변수에 할당하고 점수를 출력하고 총점, 평균 (소수점2자리 까지) 출력하는 프로그램을 구현하시오
public class Quiz5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		System.out.println("국어점수:");
		int kor = scan.nextInt();
		System.out.println("국어점수 =" + kor);
		 
		Scanner scan1 = new Scanner(System.in);
		System.out.println("수학점수:");
		int math = scan.nextInt();
		System.out.println("수학점수 =" + math);
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("영어점수");
		int eng = scan.nextInt();
		System.out.println("영어점수" + eng);
		
//		int kor = 97;
//		int math = 99;
//		int eng = 97;
		
		int sum = kor + math + eng;
		double avg = sum/3.0;
		
		System.out.printf("국어는 %d, 수학은  %d점, 영어는 %d점입니다. \n", kor, math, eng ); 
		
		System.out.printf("총점은 %d점 \n평균은 %.2f \n" , sum, avg);
	}

}
