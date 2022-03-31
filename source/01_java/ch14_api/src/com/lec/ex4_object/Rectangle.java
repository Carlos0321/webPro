package com.lec.ex4_object;
// Rectangle r1 = new Rectangle(10,5,"����")
public class Rectangle implements Cloneable{
	private int width;
	private int height;
	private String color; 
	public Rectangle() {
		color = "����";
	}
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "����";
	}
	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}
	@Override
	public String toString() {
		//return "����"+width+"cm , ����"+height+"��"+color+"�� �簢��";
		return String.format("���� %dcm, ����%dcm�� %s�� �簢��",width,height,color);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rectangle) {
			Rectangle tempObj = (Rectangle)obj;
			boolean widthCheck  = width == tempObj.width;
			boolean heightCheck = height == tempObj.height;
			boolean colorCheck  = color.equals(tempObj.color);
			return widthCheck && heightCheck && colorCheck;
		}else {
			return false;
		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
}
