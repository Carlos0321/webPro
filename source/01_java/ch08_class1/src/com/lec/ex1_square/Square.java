//패키지 명 , 클래스명 , 데이터 명, 생성자함수(오버로딩), 메소드, setter&getter 
package com.lec.ex1_square;
public class Square {
	private int side ;
	//생성자 함수자체가 없을 때 jVM이 디폴트생성자 : 아무것도 하지 않는 매개 변수 없는 생성자)
	
	public Square( ) { //생성자 함수 데이터를 초기화 할때 사용 , return type이 없어야함, 클래스명과 같은 함수  	
		System.out.println("매개변수 없는 생성자 함수 호출됨");
	}
	public Square(int side) { //매개변수 있는 생성자 함수 용도 : 데이터 초기화 
		this.side = side ;
		System.out.println("매개변수 있는 생성자 함수 호출됨. side 초기화");
	}
	public int area() {
		return side*side ; 
	}
	// setter & getter 
	
	public void setSide(int side) {
		this.side= side ;
			
	}
	public int getSide() {
		return side;
	}
}
