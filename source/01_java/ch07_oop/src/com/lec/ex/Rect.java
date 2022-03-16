package com.lec.ex;

// 데이터(private)-width/height, 메소드(public)-area()외부에서 실행가능  , setter&getter
// Rect r1 = new Rect()
public class Rect {
	private int width;
	private int height;
	public int area() {
		return width*height;  //
		
	}
	// setter & getter 만들기
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
}
