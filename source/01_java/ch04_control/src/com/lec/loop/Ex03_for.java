package com.lec.loop;
/*
 * *
 * **
 * ***
 * ****/

public class Ex03_for {

	public static void main(String[] args) {
		for(int j =1; j<=5; j++) { //5회 반복 (j가 1부터 5까지반복)
			for(int i=1; i<= j; i++) { //j회 반복 (i가 1부터 j까지 반복)
			System.out.print('*');   //질문 println하면 안되는 이유
		}//for  i
			System.out.println(); //개행
	}//for j
}//main
}