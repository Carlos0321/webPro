package com.lec.ex2;

public class ParkingSystemMainTest {
	public static void main(String[] args) {
		
		ParkingSystem p = new ParkingSystem("11��1111", 12);
		printLine();
		ParkingSystem p1 = new ParkingSystem("7��123", 15);
//		printLine1();
		printLine();
		p.out();  //��뿡�� outtime �ð��� �ޱ� 
		printLine();
		p1.out(17);  //outTime = 12�� �ޱ� 
		
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
