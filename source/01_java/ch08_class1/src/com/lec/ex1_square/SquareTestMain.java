package com.lec.ex1_square;

public class SquareTestMain {

	public static void main(String[] args) {
		Square s1 = new Square();
		System.out.println("s1의 한변의 길이 :" +s1.getSide());
		s1.setSide(5);
		System.out.println("s1의 넓이 : " + s1.area() );
		
		Square s2 = new Square(10);  //side에 10으로 초기화 
		System.out.println("s2의 넓이 : " + s2.area());
		s2.setSide(50);
		System.out.println("s2의 넓이 : " + s2.area());
	}

}
