package com.lec.ex1_string;

import java.util.Scanner;

public class Ex04_Quiz1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fn;

		System.out.println("�ֹι�ȣ�� �Է��ϼ��� : ");
		fn = sc.next();
		if ('1' == fn.charAt(7)) {
			System.out.println("����");
		} else if ('2' == fn.charAt(7)) {
			System.out.println("����");

		}
		sc.close();
	}

}
