package com.lec.quiz;

import java.util.Scanner;

//����ڷκ��� ���� �Է¹޾� ���밪�� ����ϴ� ������ �����Ͻÿ�(��, �Ű������� �޾� ���밪�� �����ϴ� �Լ�=�޼ҵ带 �̿��մϴ� 
public class Quiz01Ex {

	public static void main(String[] args) {
		int su;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� :");
		su = sc.nextInt();
		System.out.println("�Է��Ͻ� ���� ���밪�� :" + abs(su));
		sc.close();
	}

	private static int abs(int su) {
		int result = (su >= 0) ? su : -su;
		return result;

	}
}
