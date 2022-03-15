package com.lec.Quiz;

import java.util.Arrays;

public class Quiz05 {

	public static void main(String[] args) {
		int[] arr = {76,45,34,89,100,50,90,92} ;
		int [] sortArr = new int [arr.length];
		for(int i = 0 ; i< arr.length ; i++) {
			sortArr[i] = arr[i]; //sortArr안에 arr과 똑같은 숫자 넣어주기 
		}
		// 오름차순 정렬 : Arrays.sort(sortArr);
		for(int i = 0 ; i < sortArr.length-1 ; i++) { // i= 0~7까지 index
			for(int j = i+1 ; j < sortArr.length ; j++)  { // j = i+1 까지 
				// i번쨰와 j번째 비교해서 i번째가 크면 교환 
				if(sortArr[i] > sortArr[j]) {
					int temp = sortArr[i];
					sortArr[i] = sortArr[j];
					sortArr[j] = temp; //격자 알고리즘 같은 느낌 
				}//if
			}//for - i
		}//for j
		System.out.println("원 데이터 : ");
		for(int temp : arr ) {
			System.out.print(temp + " ");
		}
		System.out.print("\n오름차순 정렬 데이터 : ");
		for(int temp : sortArr ) {
			System.out.print(temp + " ");
		}
	}//main
	

}
