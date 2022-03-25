package strategy1_step5_mdularization;

import strategy1_step4_interfaces.*;

public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
//		fly =  new FlyNo();
//		missile = new MissileNo();
//		knife = new KnifeNo()
	}

}
