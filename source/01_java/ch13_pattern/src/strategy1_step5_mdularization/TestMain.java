package strategy1_step5_mdularization;

import strategy1_step4_interfaces.*;

//5�ܰ� : ����� ��ǰȭ  -> ���������� �����ϰ� 
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
		// SuperRobot ���׷��̵� ��û : �� �� �ֽ��ϴ� => ���� ��������մϴ�
		// ��������ϴ� ��ǰ ����� setFly�� ȣ�� 
		superR.setFly(new FlyHigh());  //���׷��̵� �ϼ� 
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
