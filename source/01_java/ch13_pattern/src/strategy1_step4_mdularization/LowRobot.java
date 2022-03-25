package strategy1_step4_mdularization;

import strategy1_step4_interfaces.*;

public class LowRobot extends Robot {
	
	private IMissile missile;
	private Iknife knife;
	private IFly fly;

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
//		fly =  new FlyNo();
//		missile = new MissileNo();
//		knife = new KnifeNo()
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

	public void setMissile(IMissile missile) {
		this.missile = missile;
	}

	public void setKnife(Iknife knife) {
		this.knife = knife;
	}

	public void setFly(IFly fly) {
		this.fly = fly;
	}
	
}
