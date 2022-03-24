package com.lec.ex06_volume;

public class TestMain {

	public static void main(String[] args) {
		IVolume [] volumes = {new TV(3), new Speaker(5), new TV(10), new Speaker(7)};
		for(IVolume temp : volumes) {
			temp.volumeDown();
			temp.volumeDown(20);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
			temp.volumeUP(10);
			temp.volumeUP(45);
			temp.setMute(true); // default
			System.out.println("~~~~~~~~~~~~~~~~");
		}
	}
}
