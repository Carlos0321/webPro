package com.lec.ex;
//증감 연산 : ++ --
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 10;
		int n2 = n1 --; //n1값이 하나 감소
		System.out.println("n1="+ n1+"\t n2="+n2);
		n2 = ++n1 ; // n1값이 하나 증가
		System.out.println("n1="+ n1+"\t n2="+n2);
	}
}
