package strategy1_step4_interfaces;

public class MissileNo implements IMissile {

	@Override
	public void missile() {
		System.out.println("미사일을 쏠 수 없습니다.");
	}

}
