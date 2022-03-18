package com.lec.ex4_boxOrRect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth; // box의 경우 깊이, rect일 경우는0
	private int volume; // box의 경우 부피, rect일 경우 넓이

	public BoxOrRect() {
	} // 디폴트 생성자

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth; // 초기화안하면 0으로 출력됨
	}

	public int getVolume() {
		return volume;
	}

	public void vPrint() {
		if (depth != 0) {// box volume
			System.out.println("부피는" + volume);
		} else { // rect
			System.out.println("넓이는" + volume);
		}
	}
}
