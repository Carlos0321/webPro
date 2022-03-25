package strategy1_step5_mdularization;

import strategy1_step4_interfaces.*;

//5단계 : 기능을 부품화  -> 유지보수를 간편하게 
public class TestMain {

	public static void main(String[] args) {
		SuperRobot 		superR 		= new SuperRobot();
		StandardRobot standardR 	= new StandardRobot();
		LowRobot		 lowR 		= new LowRobot();
		
		Robot[] robots = {superR, standardR, lowR};
//		for(Robot robot : robots) {
//			robot.shape();
//			robot.actionFly();
//			robot.actionKnife();
//			robot.actionMissile();
//			robot.actionRun();
//			robot.actionWalk();
//		}
		// SuperRobot 업그레이드 요청 : 날 수 있습니다 => 높이 고공비행합니다
		// 고공비행하는 부품 만들어 setFly만 호출 
		superR.setFly(new FlyHigh());  //업그레이드 완성 
		for(Robot robot : robots) {
			robot.shape();
			robot.actionFly();
			robot.actionKnife();
			robot.actionMissile();
			robot.actionRun();
			robot.actionWalk();
		}
	}
}
