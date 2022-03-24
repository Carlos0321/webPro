package strategy1_step2;

// Robot�� ��ӹ��� Ŭ���� : SuperRobot, StandardRobot, LowRobot
public class Robot {
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
}
