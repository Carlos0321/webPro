package com.lec.ex;

import java.util.Scanner;

//����ڷκ��� ���� �Է¹޾� �Է¹��� �� (3) ! = 3*2*1 (���丮�� ����ϴ� �޼ҵ� �̿�)
public class Ex06_factorial {

	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("����� �Է��ϼ��� : ");
			su = sc.nextInt();
		}while(su<=0);
		long result = factorial(su);
//		System.out.println("�Է��Ͻ�" + su+"! = "+result);
		System.out.printf("�Է��Ͻ� %d ! = %d" ,su, result);
	}
	private static long factorial(int su) { // su*factorial(su-1)  (su�� 1�ʰ��ϰ��)
		if (su==1) {
			return 1;
		} else {
			return su * factorial(su-1);  //����� �Լ� ȣ�� 
		}
}	
//	private static long factorial(int s) {
//		int result =1 ;
//		for(int i = s ; i >=1; i--) {
//			result *=i; // result = result *i
//		}
//			return result;
//		}
	}



