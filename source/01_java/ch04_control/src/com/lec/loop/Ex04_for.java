package com.lec.loop;
// 15~40���� ���� 1�ٿ� 4���� ���  1 2 3 4
                        //  5 6 7 8

public class Ex04_for {

	public static void main(String[] args) {
	  for(int i = 1 ; i<=40 ; i++) {
		  System.out.print(i+ "\t");
		  if(i%4 == 0) {
			  System.out.println(); //i�� 4�� ����̸� ���� �߰�
		  }//if
	  }//for
	}//main

}
