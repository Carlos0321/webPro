package com.lec.conditionQuiz;

import java.util.Scanner;

// 0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
// 0 <= (int)(Math.random()*3) : 0,1,2 ���� �ϳ�
public class Quiz5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int you, computer = (int) (Math.random() * 3); // 0,1,2
		System.out.println("����(0), ����(1), ��(2) �߿� �ϳ��� �����Ͻÿ� : ");
		you = sc.nextInt(); // ������ ����
		if (you == 0) {
			System.out.print("����� ����\n");
		} else if (you == 1) {
			System.out.print("����� ����\n");

		} else if (you == 2) {
			System.out.print("����� ��\n");
		} else {
			System.out.print("����� �߸� �¾��. ����");
			you = 3; // ������ ���� ����
		}
		if (you != 3) { // ��ǻ�Ͱ� �� �Ͱ� ���� ���
			String msg = (computer == 0) ? "��ǻ�ʹ� ����" : (computer == 1) ? "��ǻ�ʹ� ����" : "��ǻ�ʹ� ���ڱ�";
			System.out.println(msg);
			// ���� ���
			if (you == 0) {
				if (computer == 0) {
					System.out.println("����");
				} else if (computer == 1) {
					System.out.println("��ǻ�Ͱ� �̰��");
				} else {
					System.out.println("����� �̰��");
				} // if ���
			} else if (you == 1) {
				if (computer == 0) {
					System.out.println("����� �̰��");
				} else if (computer == 1) {
					System.out.println("���� ");
				} else {
					System.out.println("��ǻ�Ͱ� �̰��");
				} // if ���
			} else if (you == 2) {
				if (computer == 0) {
					System.out.println("��ǻ�Ͱ� �̰��");
				} else if (computer == 1) {
					System.out.println("����� �̰��");
				} else {
					System.out.println("����");
				} // if���
			} // if -���� ���
		} // if
	} // main
}// class