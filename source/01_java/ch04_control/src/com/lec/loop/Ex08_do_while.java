package com.lec.loop;

import java.util.Scanner;

// ¦����  �Է¹޴� ���α׷� ���� 
public class Ex08_do_while {

	public static void main(String[] args) {
		int you , computer;
		Scanner sc = new Scanner(System.in);
		//while(true) {
		do {
			System.out.println("¦���� �Է��ϼ��� :");
			num = sc.nextInt();
		}while(num%2 != 0) ;
		System.out.println("�Է��Ͻ� ���� ¦��" + num + "�Դϴ�");
		sc.close();  
	}

}
