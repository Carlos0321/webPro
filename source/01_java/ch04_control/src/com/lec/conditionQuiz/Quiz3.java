package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("��������  :");
		int kor = sc.nextInt() ;
		
		System.out.println("���� ���� :");
		int eng = sc.nextInt();
		
		System.out.println("���� ���� : ");
		int math = sc.nextInt();
		
	    
		double avg = (kor + eng + math) /3 ;
		System.out.printf("����� %.2f��\n", avg);
	 if(avg >= kor){
		System.out.println("���������� ��� �̻� ");
		
	}else if(avg <= kor){
		System.out.println("���������� ��� ����");
	}
	if(avg >= eng) {
		System.out.println("���������� ����̻�");
		
	}else if(avg <= eng) {
		System.out.println("���������� �������");
	}
		if(avg >= math) {
		System.out.println("���������� ��� �̻�");
	}else if(avg <= math) {
		System.out.println("���������� ��� ����");
	}
		sc.close();
	}
}
	
	
	
