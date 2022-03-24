package strategy1_step4_interfaces;

public class FlyYes implements IFly {
	@Override
	public void fly() {
		System.out.println("날 수 있습니다");
	}
}
