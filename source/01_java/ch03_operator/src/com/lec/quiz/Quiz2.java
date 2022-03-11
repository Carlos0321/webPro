package com.lec.quiz;
import java.util.Scanner;

// 입력한 수가 짝수인지 홀수인지 출력 
public class Quiz2 {

	public static void main(String[] args) {
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("숫자를 입력하시오: ");
	 int i  = scanner.nextInt() ;
	 
	 String result = i%2==0 ? "짝수" : "홀수";
	 System.out.println(result);
	}

}
