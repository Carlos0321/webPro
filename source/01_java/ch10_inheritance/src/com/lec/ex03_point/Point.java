package com.lec.ex03_point;

public class Point {
	private int x;
	private int y;
	public Point() {}   //오버로딩 (함수 중복정의)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
//	Point p = new Point(1,2);                
//	p.pointPrint();                           -1
//	System.out.println(p.infoString());       -2 
//	sysout(p)                                 -3
	
	public void pointPrint() {
		System.out.println("2차원 좌표: x="+x+", y="+y);
		
	}
	public String infoString() {
		return ("2차원 좌표: x="+x+", y="+y);
	}
	@Override
	public String toString() { //오버라이드(toString 함수 재정의) =상속받은 함수의 매개변수, 리턴타입 동일
		return ("2차원 좌표: x="+x+", y="+y);
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
