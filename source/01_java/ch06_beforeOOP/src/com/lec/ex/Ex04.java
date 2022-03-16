package com.lec.ex;

import com.lec.method.Arithmetic;

public class Ex04 {

	public static void main(String[] args) {
		int tot = Arithmetic.sum(10);
		Arithmetic ar = new Arithmetic() ;
		System.out.println("-7의 절대값은" + ar.abs(-7));
	}

}
