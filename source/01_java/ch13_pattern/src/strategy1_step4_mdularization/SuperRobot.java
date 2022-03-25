package strategy1_step4_mdularization;

import strategy1_step4_interfaces.FlyYes;
import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.Iknife;
import strategy1_step4_interfaces.KnifeLazer;
import strategy1_step4_interfaces.MissileYes;

public class SuperRobot extends Robot {
	private IFly fly ;
	private IMissile missile;
	private Iknife knife;
	
	public SuperRobot() {
		setFly(new FlyYes()); //fly = new FlyYes();
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
	public void actionKnife() {
		knife.knife();
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(Iknife knife) {
		this.knife = knife;
	}
	

}
