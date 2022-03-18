package com.lec.ex4_boxOrRect;

public class BoxOrRectTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoxOrRect box = new BoxOrRect(5,6,10);
		BoxOrRect rect = new BoxOrRect(10,5);
		box.vPrint();
		rect.vPrint();
		System.out.println("박스 부피는" + box.getVolume());
		System.out.println("rect 부피는" + box.getVolume());
	}

}
