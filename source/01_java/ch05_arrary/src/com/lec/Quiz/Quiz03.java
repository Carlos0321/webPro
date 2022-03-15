package com.lec.Quiz;

import java.util.Scanner;

// 76 45 34 89 100 50 90 92 8개의 값을 1차원 배열로 초기화 하고 
//  값에 합계와 평균 그리고 최대 최소값을 구하는 프로그램을 작성하시오 
public class Quiz03 {

	public static void main(String[] args) {
		int[] arr = { 76, 45, 34, 89, 100, 50, 90, 92 };
		int sum = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			sum = sum + arr[idx];
		}
		System.out.println("합계:" + sum);
		System.out.println("평균 :" + (double) sum / arr.length);

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
		System.out.printf("최대값은 %s\n", arr[maxIdx], max);
		System.out.printf("최소값은 %s", arr[minIdx], min);
	}
}