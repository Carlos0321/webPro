package com.lec.ex;

// 일반 for문 vs 확장 for문 (배열 출력할떄만)
public class Ex02 {

	public static void main(String[] args) {
		int[] arr = new int[3]; // = {0,0,0}
		for (int idx = 0; idx < arr.length; idx++) { // 일반 for문을 이용한 출력
			System.out.printf("arr[%d]=%d\n", idx, arr[idx]);
		}
		for (int temp : arr) { // 확장 for문을 이용한 출력 질문하기!!
			System.out.println(temp);
		}
		for (int i = 0; i < arr.length; i++) { // 일반 for문을 이용한 배열 수정 가능
			arr[i] = 5;
		}
		for (int temp : arr) { // 확장 for문을 이용한 배열 변경 불가
			temp = 9;
		}
		System.out.println("수정후");
		for (int temp : arr) { // 확장 for문을 이용한 출력
			System.out.println(temp);

		}
	}
}
