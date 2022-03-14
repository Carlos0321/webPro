package com.lec.loop;
// 15~40까지 한줄 1줄에 4개씩 출력  1 2 3 4
                        //  5 6 7 8

public class Ex04_for {

	public static void main(String[] args) {
	  for(int i = 1 ; i<=40 ; i++) {
		  System.out.print(i+ "\t");
		  if(i%4 == 0) {
			  System.out.println(); //i가 4의 배수이면 개행 추가
		  }//if
	  }//for
	}//main

}
