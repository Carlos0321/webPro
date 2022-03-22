package com.lec.ex3_shape;

public class Triangle extends Shape {
	private int w;  //πÿ∫Ø
	private int h;  //≥Ù¿Ã
	
	public Triangle(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	@Override
	public double computeArea() {
		return w*h*0.5;
	}

}
