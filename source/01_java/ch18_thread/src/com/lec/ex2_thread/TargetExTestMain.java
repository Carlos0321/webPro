package com.lec.ex2_thread;
public class TargetExTestMain {
	public static void main(String[] args) {
		TargetEx01 threadA = new TargetEx01("A");
		TargetEx02 threadB = new TargetEx02();
		threadB.setName("B");
		threadA.start();
		threadB.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println("main ÇÔ¼ö ³¡");
	}
}
