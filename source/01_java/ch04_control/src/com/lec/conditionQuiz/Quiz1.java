package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��Ͻÿ� : ");
		int su = sc.nextInt();
		if(su>=0) {
			System.out.printf("�Է��Ͻ� ���� ���밪�� %d, su", su);
		}else {
			System.out.printf("�Է��Ͻ� ���� ���밪�� %d, -su", -su);
		}
	
	sc.close();
	}
}