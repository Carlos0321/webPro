package com.lec.ex2;

public class ParkingSystemMainTest {
	public static void main(String[] args) {
		
		ParkingSystem p = new ParkingSystem("11라1111", 12);
		printLine();
		ParkingSystem p1 = new ParkingSystem("7가123", 15);
//		printLine1();
		printLine();
		p.out();  //사용에게 outtime 시간을 받기 
		printLine();
		p1.out(17);  //outTime = 12로 받기 
		
	}

	private static void printLine() {
		for(int i =0; i<30 ; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
//	private static void printLine1() {
//		for(int i =0; i<30 ; i++) {
//			System.out.print('-');
//		}
//		System.out.println();
	
}
