package com.lec.ex;

import java.util.Scanner;

// 사용자로부터 영희, 철수, 길동, 영수, 말자의 키를 입력받아 , 평균키를 출력 
// 최장신이름과 키, 최단신 이름과 키 출력 
public class Ex05_miniMax {

	public static void main(String[] args) {
		String[] arrName = { "영희", "철수", "길동", "영수", "말자" };
		int[] arrHeight = new int[arrName.length];
		Scanner sc = new Scanner(System.in);
		int totalHeight = 0; // 0으로 청소해야되는 이유는 ? //입력 받은 키 누적 변수
		for (int idx = 0; idx < arrName.length; idx++) {
			System.out.println(arrName[idx] + "의 키는 :");
			arrHeight[idx] = sc.nextInt();
			totalHeight += arrHeight[idx];
		}
		System.out.println("평균키는" + (double) totalHeight / arrName.length);
		sc.close();
		// 최장신이름과 키, 최단신 이름과 키 출력
		int minHeight = 999, minIdx = -1; // 최단신 키와 index(위치) 제일 큰 값으로 초기화 해야지 최솟값 찾을 수 있음
		int maxHeight = 0, maxIdx = -1; // 최장신 키와 index(위치)
		for (int i = 0; i < arrName.length; i++) {
			if (arrHeight[i] < minHeight) {
				minHeight = arrHeight[i];
				minIdx = i;
			} // if -최단신 키와 최단신 index찾기
			if (arrHeight[i] > maxHeight) {
				maxHeight = arrHeight[i];
				maxIdx = i;
			} // if =최장신 키와 최장신index 찾기
		} // for
		System.out.printf("최장신 학생은 %s, 키는 %d\n", arrName[maxIdx], maxHeight);
		System.out.printf("최단신 학생은 %s, 키는 %d\n", arrName[minIdx], minHeight);
	}

}
