package strategy1_step3;

public class TestMain {

	public static void main(String[] args) {
		Robot[] robots = {new SuperRobot(), new StandardRobot(), new LowRobot()};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionRun();
			robot.actionWalk();
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
//			if(robot instanceof SuperRobot) {
//				SuperRobot r = (SuperRobot) robot;
//				r.actionFly();
//				r.actionMissile();
//				r.actionKnife();
//			}else if(robot instanceof StandardRobot) {
//				StandardRobot r = (StandardRobot)robot;
//				r.actionFly();
//				r.actionMissile();
//				r.actionKnife();
//			}else if(robot instanceof StandardRobot) {
//				LowRobot r = (LowRobot)robot;
//				r.actionFly();
//				r.actionMissile();
//				r.actionKnife();
//			}
		}
	}

}
