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
			System.out.println("SPEAKER 볼륨을 1올려서 현재" + volumeLevel);
		} else {
			System.out.println("SPEAKER 볼륨이 최대치여서 올리지 못했습니다");
		}
	}

	@Override
	public void volumeUP(int level) {
		if(volumeLevel + level <= SPEAKER_MAX_VOLUME) { //level 만큼 볼륨 올림 
			volumeLevel += level; 
			System.out.println("SPEAKER 볼륨을 "+level+"만큼 올려서 현재 : " + volumeLevel);
		}else { //level만큼 못 올릴 경우 ex. 현재 볼륨 45 level 10 => 몇만큼 올릴지 계산, 볼륨은 50 
			int tempLevel = SPEAKER_MAX_VOLUME - volumeLevel;
			volumeLevel = SPEAKER_MAX_VOLUME;
			System.out.println("SPEAKER 볼륨을 "+level+"만큼 못 올리고 "+tempLevel+"만큼 올려 최대치"+SPEAKER_MAX_VOLUME  );
		}
	}

	@Override
	public void volumeDown() {
		if(volumeLevel > SPEAKER_MIN_VOLUME) {
			volumeLevel --;
			System.out.println("SPEAKER 볼륨을 1만큼 내려서 현재 : " + volumeLevel);
		}else {
			System.out.println("SPEAKER볼륨이 최소치입니다");
		}
	}

	@Override
	public void volumeDown(int level) {
		if(volumeLevel - level >= SPEAKER_MIN_VOLUME) {
			volumeLevel -= level;
			System.out.println("SPEAKER 볼륨을" +level+"내려서 현재 : "+volumeLevel);
		}else {
			int tempLevel = SPEAKER_MIN_VOLUME ;
			volumeLevel = SPEAKER_MIN_VOLUME;
			System.out.println("SPEAKER 볼륨을 "+ level+"만큼 못 내리고"+tempLevel+"만큼 내려 최소치"+SPEAKER_MIN_VOLUME);
		}
	}

}
