package com.lec.ex;

import java.util.Scanner;

// ����ڷκ��� ����, ö��, �浿, ����, ������ Ű�� �Է¹޾� , ���Ű�� ��� 
// ������̸��� Ű, �ִܽ� �̸��� Ű ��� 
public class Ex05_miniMax {

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
		sc.close();
		// ������̸��� Ű, �ִܽ� �̸��� Ű ���
		int minHeight = 999, minIdx = -1; // �ִܽ� Ű�� index(��ġ) ���� ū ������ �ʱ�ȭ �ؾ��� �ּڰ� ã�� �� ����
		int maxHeight = 0, maxIdx = -1; // ����� Ű�� index(��ġ)
		for (int i = 0; i < arrName.length; i++) {
			if (arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if -�ִܽ� Ű�� �ִܽ� indexã��
			if (arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if =����� Ű�� �����index ã��
		} // for
		System.out.printf("����� �л��� %s, Ű�� %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("�ִܽ� �л��� %s, Ű�� %d\n", arrName[minIdx], minHeight);
	}

}
