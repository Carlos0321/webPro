package strategy1_step4_mdularizaion;

import strategy1_step4_interfaces.FlyNo;

public class TestMain {

	public static void main(String[] args) {
		SuperRobot robot = new SuperRobot();
		robot.actionFly();
		robot.setFly(new FlyNo());
		robot.actionFly();
	}

}
