package com.lec.ex05_lib;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		BookLib book1 = new BookLib("89a-01","java","ȫ�浿");
		BookLib book2 = new BookLib("89a-02","DBMS","��ġ");
		System.out.println(book1); //�̺κ� ��ħ 
		try {
			book1.checkOut("�뿩��");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}   
		//������ ���� 
		book1.setCheckOut(new Date(122,2,11)); // 3�� 11�Ͽ� ���������� ���� 
		System.out.println(book1);
		try {
			book1.checkIn();
		} catch (Exception e) {
			System.out.println("���� �޼��� : "+e.getMessage());
		}
	}
	

}