package com.lec.Quiz;

import java.util.Arrays;

public class Quiz05 {

	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92} ;
		int [] sortArr = new int [arr.length];
		for(int i = 0 ; i< arr.length ; i++) {
			sortArr[i] = arr[i]; //sortArr�ȿ� arr�� �Ȱ��� ���� �־��ֱ� 
		}
		// �������� ���� : Arrays.sort(sortArr);
		for(int i = 0 ; i < sortArr.length-1 ; i++) { // i= 0~7���� index
			for(int j = i+1 ; j < sortArr.length ; j++)  { // j = i+1 ���� 
				// i������ j��° ���ؼ� i��°�� ũ�� ��ȯ 
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp; //���� �˰��� ���� ���� 
				}//if
			}//for - i
		}//for j
		System.out.println("�� ������ : ");
		for(int temp : arr ) {
			System.out.print(temp + " ");
		}
		System.out.print("\n�������� ���� ������ : ");
		for(int temp : sortArr ) {
			System.out.print(temp + " ");
		}
	}//main
	

}
