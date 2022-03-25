package strategy1_step5_mdularization;

import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.Iknife;
// Robot r = new Robot();
// r.actionFly() ; ����(�����ڿ��� fly = new FlyNo(); ���ؼ�) �̸� �����ϰ��� ��ü�����Ұ��ϵ��� abstract class
public abstract class Robot {
	private IMissile missile;
	private Iknife knife;
	private IFly fly;
	
	public void actionWalk() {
		System.out.println("���� �� �ֽ��ϴ�");
	}

	public void actionRun() {
		System.out.println("�� �� �ֽ��ϴ�");
	}

	public void shape() {
		String className = getClass().getName(); // stategy1.step2.SuperRobot
		int idx = className.lastIndexOf('.'); // �� ������ '.'�� �ִ� ��ġ
		String name = className.substring(idx + 1); // idx+1��° �۾����� ������
		System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public  void actionFly() {
		fly.fly();
	}
	public  void actionMissile() {
		missile.missile();
	}
	public  void actionKnife() {
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

