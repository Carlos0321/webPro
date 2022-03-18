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
		System.out.println(carnumber + "님 어서 오세요. \n" + "입차시간 : " + inTime + "시");

	}

	public void out() {
		Scanner sc = new Scanner(System.in);
		System.out.println("몇시에 나가시나요 ? : ");
		outTime = sc.nextInt();
		out(outTime);
		sc.close();
	}
	public void out(int outTime) {
		fee = (outTime - inTime) * Constant.HOURLYPARKINGRATE;
		this.outTime = outTime;
		int time = (outTime - inTime);
		System.out.println(carnumber + "님 안녕히 가세요. \n" + "입차시간 : " + inTime + "시\n" + "출차시간 : " + outTime + "시\n"
				+ "주차시간 : " + time+"시간동안 주차하셨습니다\n"+ "주차요금 : " + fee+"원");
	}

	public int getYou() {
		return you;
	}

	public void setYou(int you) {
		this.you = you;
	}

}
