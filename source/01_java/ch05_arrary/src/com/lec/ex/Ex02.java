package com.lec.ex;

// �Ϲ� for�� vs Ȯ�� for�� (�迭 ����ҋ���)
public class Ex02 {

	public static void main(String[] args) {
		int[] arr = new int[3]; // = {0,0,0}
		for (int idx = 0; idx < arr.length; idx++) { // �Ϲ� for���� �̿��� ���
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for (int temp : arr) { // Ȯ�� for���� �̿��� ��� �����ϱ�!!
			System.out.println(temp);
		}
		for (int i = 0; i < arr.length; i++) { // �Ϲ� for���� �̿��� �迭 ���� ����
			arr[i] = 5;
		}
		for (int temp : arr) { // Ȯ�� for���� �̿��� �迭 ���� �Ұ�
			temp = 9;
		}
		System.out.println("������");
		for (int temp : arr) { // Ȯ�� for���� �̿��� ���
			System.out.println(temp);

		}
	}
}