package com.lec.ex06_volume;
// SPEAKER SPEAKER =new SPEAKER(3)
// SPEAKER.volumeUP()
public class Speaker implements IVolume {
	private int volumeLevel;
	private static final int SPEAKER_MAX_VOLUME = 100;
	private static final int SPEAKER_MIN_VOLUME = 0;

	public Speaker() {
	}

	public Speaker(int volumeLevel) {
		this.volumeLevel = volumeLevel;
	}

	@Override
	public void volumeUP() {
		if (volumeLevel < SPEAKER_MAX_VOLUME) {
			volumeLevel++;
			System.out.println("SPEAKER ������ 1�÷��� ����" + volumeLevel);
		} else {
			System.out.println("SPEAKER ������ �ִ�ġ���� �ø��� ���߽��ϴ�");
		}
	}

	@Override
	public void volumeUP(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { //level ��ŭ ���� �ø� 
			volumeLevel += level; 
			System.out.println("SPEAKER ������ "+level+"��ŭ �÷��� ���� : " + volumeLevel);
		}else { //level��ŭ �� �ø� ��� ex. ���� ���� 45 level 10 => �ŭ �ø��� ���, ������ 50 
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER ������ "+level+"��ŭ �� �ø��� "+tempLevel+"��ŭ �÷� �ִ�ġ"+SPEAKER_MAX_VOLUME  );
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("SPEAKER ������ 1��ŭ ������ ���� : " + volumeLevel);
		}else {
			System.out.println("SPEAKER������ �ּ�ġ�Դϴ�");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("SPEAKER ������" +level+"������ ���� : "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MIN_VOLUME ;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER ������ "+ level+"��ŭ �� ������"+tempLevel+"��ŭ ���� �ּ�ġ"+SPEAKER_MIN_VOLUME);
		}
	}

}
