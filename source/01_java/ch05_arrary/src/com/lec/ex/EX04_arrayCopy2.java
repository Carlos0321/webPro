package com.lec.ex;
// API�� �̿��� �迭 ����  System.arraycopy(�����迭, ��������idx,���纻 �迭, ���纻 ����idx, ����)
public class EX04_arrayCopy2 {

	public static void main(String[] args) {
		int [] score = {100, 10, 20, 30, 40};
		int [] s = new int [score.length];
		System.arraycopy(score, 0, s, 0, score.length);
//		for(int idx = 0 ; idx<score.length; idx++){ //for���� �̿��� �迭 ���� 
//			s[idx] = score[idx];
//		}
		s[0] = 999;
		for(int idx=0 ; idx<score.length; idx++) {
			System.out.printf("score[%d] =%d\t s[%d]= %d\n", idx, score[idx], idx, s[idx]);  
		}
	}

}
