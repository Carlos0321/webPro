package com.lec.ex;

// �迭�� 1���� �迭�� �ַ� ����. 2���� �迭�� �����ͺ��̽��� ���� 
public class Ex06_multiDimensional {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		int[][] test = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(arr[2]); // 0~2�� index
		System.out.println(test[0][0]); // 0~1�� 0~2��
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				System.out.printf("test[%d][%d] = %d\n", i, j, test[i][j]);
			} // for j
		} // for i
	}

}