package com.lec.ex1_string;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		String str1 = "Java";
		String str2 = "Java";
		// String�� new�� �������� �ʰ�, ""�� ����� ���ڿ� ����� �̿�. �ڵ����� �������� String ��ü�� �̹� �����ϴ��� Ȯ���ϰ�
		// �̹� �����ϴ� ���ڿ� ��ü�� ����. �������� ������ String ��ü ����
		String str3 = new String("Java"); // new�ϸ� ������ ����
		if (str1 == str2) {
			System.out.println("str1�� str2�� ���� �ּҰ��� ����");
		} else {
			System.out.println("str1�� str2�� �ٸ� �ּҰ��� ����");
		}

		if (str1.equals(str2)) {
			System.out.println("���� ���ڿ� ");
		}
		System.out.println(str1==str3 ? "str1�� str3�� ���� �ּ�" : "str1�� str3�� �ٸ� �ּ� ");
		System.out.println(str1.equals(str3)? "���� ��Ʈ��" : "�ٸ� ���ڿ�");
	}
}