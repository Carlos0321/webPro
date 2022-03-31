package com.lec.ex3_math;

import java.util.Random;

// 로또번호 6개 뽑기 
public class Ex05_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		for (int idx = 0; idx < lotto.length; idx++) {
			//lotto[idx] = random.nextInt(45) + 1;  중복될 수 있다 
			int temp = random.nextInt(45) + 1; // 뽑은 난수를 임시 변수에 저장하고 0~idx번째에 temp가 있는지 확인 
			boolean ok = true ;  //뽑은 난수가 중복이 아닐 경우 true/ 중복일 경우 false
			for(int i=0 ; i <idx ; i++) {
				if(temp == lotto[i]) { // 뽑은 난수가 중복이니 다시 뽑아 
					idx --;
					ok = false;
					break;
				}
			} // for : 발생된 난수가 이전 앞방에 저장되었는지 확인(중복된 난수인지 확인) 
			if(ok) {
				lotto[idx] =temp;
			}
			// System.out.println("로또 번호 뽑기 : " + (random.nextInt(45)+1) );
		} // for
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) { // i번째 수가 j번쨰 수보다 크면 바꿈
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // 오름 차순 정렬
		for (int l : lotto) {
			System.out.println(l + "");
		}

	}// main
}// class
