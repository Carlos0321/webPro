package com.lec.ex06_volume;

public interface IVolume {
	public void volumeUP();
	public void volumeUP(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) {
		if(mute) {
			System.out.println("음소거");
		}else {
			System.out.println("음소거 해제");
		}
	}
}
