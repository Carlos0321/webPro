package strategy1_step4_mdularization;
//4단계 : 기능을 부품화 
public class TestMain {

	public static void main(String[] args) {
		SuperRobot 		superR 		= new SuperRobot();
		StandardRobot standardR 	= new StandardRobot();
		LowRobot		 lowR 		= new LowRobot();
		
		Robot[] robots = {superR, standardR, lowR};
		for(Robot robot : robots) {
			robot.shape();
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
			robot.actionRun();
			robot.actionWalk();
		}
		//lowR.setFly(new FlyYes()); 5단계에서 해결 
	}

}
