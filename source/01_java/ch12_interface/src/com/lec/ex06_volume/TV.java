package com.lec.ex06_volume;
// TV tv =new TV(3)
// tv.volumeUP()
public class TV implements IVolume {
	private int volumeLevel;
	private static final int TV_MAX_VOLUME = 50;
	private static final int TV_MIN_VOLUME = 0;

	public TV() {
	}

	public TV(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUP() {
		if (volumeLevel < TV_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("TV ������ 1�÷��� ����" + volumeLevel);
		} else {
			System.out.println("TV ������ �ִ�ġ���� �ø��� ���߽��ϴ�");
		}
	}

	@Override
	public void volumeUP(int level) {
		if(volumeLevel + level <= TV_MAX_VOLUME) { //level ��ŭ ���� �ø� 
			volumeLevel += level; 
			System.out.println("TV ������ "+level+"��ŭ �÷��� ���� : " + volumeLevel);
		}else { //level��ŭ �� �ø� ��� ex. ���� ���� 45 level 10 => �ŭ �ø��� ���, ������ 50 
			int tempLevel = TV_MAX_VOLUME - volumeLevel;
			volumeLevel = TV_MAX_VOLUME;
			System.out.println("TV ������ "+level+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ"+TV_MAX_VOLUME  );
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > TV_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("TV ������ 1��ŭ ������ ���� : " + volumeLevel);
		}else {
			System.out.println("TV������ �ּ�ġ�Դϴ�");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= TV_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("TV ������" +level+"������ ���� : "+volumeLevel);
		}else {
			int tempLevel = TV_MIN_VOLUME ;
			volumeLevel = TV_MIN_VOLUME;
			System.out.println("TV ������ "+ level+"��ŭ �� ������"+tempLevel+"��ŭ ���� �ּ�ġ"+TV_MIN_VOLUME);
		}
	}

}
