package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾� , ���Ű�� ��� 

public class Ex05_avg {

	public static void main(String[] args) {
		String[] arrName = { "����", "ö��", "�浿", "����", "����" };
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 0���� û���ؾߵǴ� ������ ? //�Է� ���� Ű ���� ����
		for (int idx = 0; idx < arrName.length; idx++) {
			System.out.println(arrName[idx] + "�� Ű�� :");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("���Ű��" + (double) totalHeight / arrName.length);
	}

}