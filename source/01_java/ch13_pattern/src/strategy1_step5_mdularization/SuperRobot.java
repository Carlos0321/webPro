package strategy1_step5_mdularization;

import strategy1_step4_interfaces.FlyYes;
import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.Iknife;
import strategy1_step4_interfaces.KnifeLazer;
import strategy1_step4_interfaces.MissileYes;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes()); // fly = new FlyYes();
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}

}
