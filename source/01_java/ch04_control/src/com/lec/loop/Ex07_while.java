package com.lec.loop;
// 1~100까지 3의 배수의 합만 누적한 결과는 ?
public class Ex07_while {

	public static void main(String[] args) {
		int sum= 0 ;
		int i = 1;
		while(i<101) {
			if(i%3==0) {
				sum += i;
				
			}
			++i;
		}
//		for(int i=1; i < 101; i++) {
//			if(i%3==0) {
//				sum += i; //sum = sum+ i;
//			}
//		}
		System.out.println("누적합은" + sum);
		
	}

}
