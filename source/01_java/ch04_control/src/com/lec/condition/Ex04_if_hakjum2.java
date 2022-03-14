package com.lec.condition;

import java.util.Scanner;

// 사용자로부터 점수를 입력받아 학점 출력
public class Ex04_if_hakjum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("점수 : ");
		int score = sc.nextInt();
		int temp = score == 100 ? score - 1 : score;   //
		temp = (-9<=temp && temp<0)? -10 : temp;
		switch (score / 10) { // 강사님께 질문 /10하는 이유

		case 10:System.out.println();
		case 9: System.out.println("A학점"); break;
		case 8: System.out.println("B학점"); break;
		case 7: System.out.println("C학점"); break;
		case 6: System.out.println("D학점"); break;

		case 5:	case 4: case 3:	case 2:	case 1:	case 0:
			System.out.println("F학점");	break;
		default:
			System.out.println("유효하지않는 점수입니다");

//		if( (90 <= score) && score <= 100) {
//		System.out.println("A학점");
//		} else if( (80 <= score) && score <= 90) {
//		   System.out.println("B학점"); 
//	    } else if( (70 <= score) && score <= 80) {
//	    System.out.println("C학점");
//	    } else if( (60 <= score) && score <= 70) {
//		    System.out.println("D학점");
//	    } else if( (0 <= score) && score <= 60) {
//		    System.out.println("F학점") ;
//	}else {
//		System.out.println("유효한 점수가 아닙니다");
		}
	}
}
