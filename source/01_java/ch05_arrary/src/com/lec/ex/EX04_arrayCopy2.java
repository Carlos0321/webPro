package com.lec.ex;
// API를 이용한 배열 복사  System.arraycopy(원본배열, 원본시작idx,복사본 배열, 복사본 시작idx, 개수)
public class EX04_arrayCopy2 {

	public static void main(String[] args) {
		int [] score = {100, 10, 20, 30, 40};
		int [] s = new int [score.length];
		System.arraycopy(score, 0, s, 0, score.length);
//		for(int idx = 0 ; idx<score.length; idx++){ //for문을 이용한 배열 복사 
//			s[idx] = score[idx];
//		}
		s[0] = 999;
		for(int idx=0 ; idx<score.length; idx++) {
			System.out.printf("score[%d] =%d\t s[%d]= %d\n", idx, score[idx], idx, s[idx]);  
		}
	}

}
