package com.lec.Quiz;

public class Quiz01 {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
//      for (int temp : arr ) {
//			tot += temp;
		}
		System.out.println("�迭�� ��� ���� �հ�� :" + sum);
	}
}