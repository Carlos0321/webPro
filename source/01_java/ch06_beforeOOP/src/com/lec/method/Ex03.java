package com.lec.method;
// Arithmetic.sum /.은 ~안에 들어있다는 의미 (sum/evenOdd)static메소드 vs abs(일반메소드)
public class Ex03 {
//static은 class만 있으면 사용할 수 있다 . 
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10); // Arithmetic 패키지 안에 있는것을 사용할떄 
		System.out.println("1~10까지 합은 "+ tot);
		System.out.println(Arithmetic.evenOdd(tot));
		Arithmetic ar = new Arithmetic() ; //instance (stack메모리로 가져옴)
		System.out.println(ar.abs(-8));
	}

}
