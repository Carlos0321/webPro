package com.lec.Quiz;

import java.util.Scanner;

// 76 45 34 89 100 50 90 92 8���� ���� 1���� �迭�� �ʱ�ȭ �ϰ� 
//  ���� �հ�� ��� �׸��� �ִ� �ּҰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ� 
public class Quiz03 {

	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			sum = sum + arr[idx];
		}
		System.out.println("�հ�:" + sum);
		System.out.println("��� :" + (double) sum / arr.length);

		int min = 999, minIdx = -1;
		int max = 0, maxIdx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				minIdx = i;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxIdx = i;
			}
		}
		System.out.printf("�ִ밪�� %s\n", arr[maxIdx], max);
		System.out.printf("�ּҰ��� %s", arr[minIdx], min);
	}
}