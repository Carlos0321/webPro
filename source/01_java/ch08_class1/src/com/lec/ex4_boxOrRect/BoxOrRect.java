package com.lec.ex4_boxOrRect;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth; // box�� ��� ����, rect�� ����0
	private int volume; // box�� ��� ����, rect�� ��� ����

	public BoxOrRect() {
	} // ����Ʈ ������

	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		volume = width * height;
	}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		volume = width * height * depth; // �ʱ�ȭ���ϸ� 0���� ��µ�
	}

	public int getVolume() {
		return volume;
	}

	public void vPrint() {
		if (depth != 0) {// box volume
			System.out.println("���Ǵ�" + volume);
		} else { // rect
			System.out.println("���̴�" + volume);
		}
	}
}