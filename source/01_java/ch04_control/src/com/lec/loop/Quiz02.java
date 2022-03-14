package com.lec.loop;

public class Quiz02 {

	public static void main(String[] args) {
		int tot = 0 ;
		for(int i=1 ; i<11; i++) {
			if(i%2 != 0) {
				tot += i;
		}//if
	}//for
		System.out.println("1~10까지의 홀수의 합은"+ tot);
	}//main
}//class
