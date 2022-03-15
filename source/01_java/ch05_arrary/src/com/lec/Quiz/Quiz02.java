package com.lec.Quiz;

public class Quiz02 {

	public static void main(String[] args) {
		int[][ ]arr= {{5,5,5,5,5} , {10,10, 10, 10, 10},
				       {20,20,20,20,20}, {30,30,30,30,3}} ;
		int sum = 0 ;
		for(int idx = 0 ; idx <arr.length ; idx++) {
			for (int j = 0; j < arr[idx].length; j++) {
			sum += arr[idx][j] ;
		}
		}
		System.out.println(sum);
	}
}


