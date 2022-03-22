package com.lec.ex3_shape;

import com.lec.cons.Constant;

public class Circle extends Shape {
	private int r ; //¹ÝÁö¸§
	
	public Circle(int r) {
		super();
		this.r = r;
	}

	@Override
	public double computeArea() {
		return Constant.PI*r*r;
	}

}
