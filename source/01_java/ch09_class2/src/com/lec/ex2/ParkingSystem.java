package com.lec.ex2;

import java.util.Scanner;

import com.lec.cons.Constant;

public class ParkingSystem {
	private String carnumber;
	private int inTime;
	private int outTime;
	private int fee;
	private int you;
//	private final int HOURLYPARKINGRATE =2000;
	public ParkingSystem() {
	}

	public ParkingSystem(String carnumber, int inTime) {

		this.carnumber = carnumber;
		this.inTime = inTime;
		System.out.println(carnumber + "�� � ������. \n" + "�����ð� : " + inTime + "��");

	}

	public void out() {
		Scanner sc = new Scanner(System.in);
		System.out.println("��ÿ� �����ó��� ? : ");
		outTime = sc.nextInt();
		out(outTime);
		sc.close();
	}
	public void out(int outTime) {
		fee = (outTime - inTime) * Constant.HOURLYPARKINGRATE;
		this.outTime = outTime;
		int time = (outTime - inTime);
		System.out.println(carnumber + "�� �ȳ��� ������. \n" + "�����ð� : " + inTime + "��\n" + "�����ð� : " + outTime + "��\n"
				+ "�����ð� : " + time+"�ð����� �����ϼ̽��ϴ�\n"+ "������� : " + fee+"��");
	}

	public int getYou() {
		return you;
	}

	public void setYou(int you) {
		this.you = you;
	}

}
