package com.lec.conditionQuiz;

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("����(0), ����(1), ��(2) �� �ϳ��� �����ϼ��� : ");
	int you = sc.nextInt() ;
	if(you == 0) {
		System.out.println("�ʴ� ������ �¾�");
	}else if (you == 1) {
		System.out.println("�ʴ� ������ �¾�");
	}else if(you == 2){
		System.out.println("�ʴ� ���ڱ⸦ �¾�");
	}else {
		System.out.println("��ȿ���� �ʴ� ���Դϴ�");
		
	}
	sc.close();
	}
	


}
