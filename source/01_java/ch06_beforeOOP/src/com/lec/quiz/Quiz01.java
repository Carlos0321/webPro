package com.lec.quiz;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		int su ;
		Scanner sc  = new Scanner(System.in);
		do {
			System.out.print("���ϴ� �ܼ��� �Է��Ͻÿ� :");
			su = sc.nextInt();
			if(su <2 || su>9) {
				System.out.println("�� �ٽ��Է��ϼ��� : ");
			}
		}while(su <2 || su>9);
		dansu(su);  // �޼ҵ�(�Լ�)�� �����Ͽ� ȣ�� 
		sc.close();
	}
	private static void dansu(int su) {  //�޼ҵ� ���ǳ�����
		for(int i=1 ; i<10 ; i++) {
			System.out.println(su + "*" +i+ " = " +su*i);
		}
	}
}
