package com.lec.conditionQuiz;

import java.util.Scanner;

// 0 <= Math.random() <1
// 0 <= Math.random()*3 < 3
// 0 <= (int)(Math.random()*3) : 0,1,2 ���� �ϳ�
public class Quiz6 {

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
			//����� �� 3���� : ����, �̰��, ���� 
		//if(you==0 &&computer==1 || (you==1) || (computer==2)) {
		if((you+1)%3 == computer){	
			System.out.println("you�� ����.");
		}else if (you == computer) {
			System.out.println("����");
		}else {
			System.out.println("�̰��");
		}// if ����-���
		} // if
	} // main
}// class