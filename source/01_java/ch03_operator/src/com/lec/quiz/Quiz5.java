package com.lec.quiz;

import java.util.Scanner;

// ����, ����, ����, ������ ������ �Ҵ��ϰ� ������ ����ϰ� ����, ��� (�Ҽ���2�ڸ� ����) ����ϴ� ���α׷��� �����Ͻÿ�
public class Quiz5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		System.out.println("��������:");
		int kor = scan.nextInt();
		System.out.println("�������� =" + kor);
		 
		Scanner scan1 = new Scanner(System.in);
		System.out.println("��������:");
		int math = scan.nextInt();
		System.out.println("�������� =" + math);
		
		Scanner scan2 = new Scanner(System.in);
		System.out.println("��������");
		int eng = scan.nextInt();
		System.out.println("��������" + eng);
		
//		int kor = 97;
//		int math = 99;
//		int eng = 97;
		
		int sum = kor + math + eng;
		double avg = sum/3.0;
		
		System.out.printf("����� %d, ������  %d��, ����� %d���Դϴ�. \n", kor, math, eng ); 
		
		System.out.printf("������ %d�� \n����� %.2f \n" , sum, avg);
	}

}
