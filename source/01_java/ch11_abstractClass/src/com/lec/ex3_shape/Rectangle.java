package com.lec.ex3_shape;

public class Rectangle extends Shape {
	private int w;  //가로
	private int h;  //세로
	public Rectangle ( ) {}
	public Rectangle(int w, int h) {
		this.w = w;
		this.h = h;
	}
	@Override
	public double computeArea() {
		return w*h;
	}

}
