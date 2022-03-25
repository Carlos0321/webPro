package strategy1_step4_mdularization;

import strategy1_step4_interfaces.*;

public class StandardRobot extends Robot {
	private IFly fly = new FlyNo();
	private IMissile missile;
	private Iknife knife;
	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
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
