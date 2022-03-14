package com.lec.loop;
// 2*1=2	3*1=3	4*1=4	5*1=5	6*1=6	7*1=7	8*1=8	9*1=9	
//
public class Quiz04 {

	public static void main(String[] args) {
		for(int i = 1; i<10; i++) { //1~9
			for(int j=2 ; j<10 ; j++) { //2단부터 9단까지
				System.out.printf("%d* %d = %d\t", j, i, j*i);
			}// for j
			System.out.println(); //개행
		}//for i
	}//main

}
