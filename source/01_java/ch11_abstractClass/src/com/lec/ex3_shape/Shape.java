package com.lec.ex3_shape;
// Shape�� ���� Rectangle(w,h) , Triangle(w,h) Circle(r)�� �� ������ �� 
public abstract class Shape {
	public void draw() {
		String className = this.getClass().getName(); // com.lec.ex3_shape.Circle
		                                              // com.lec.ex3_shape.Rect
		System.out.println(this.getClass().getName()+"������ �׷���");
	}
	public abstract double computeArea(); //�߻� �޼ҵ�
}
