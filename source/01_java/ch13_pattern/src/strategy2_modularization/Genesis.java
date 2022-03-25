package strategy2_modularization;
// ��ӹ��� ��� : // 3���� ��ǰ ����  /������ X / �޼ҵ�O drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�) fuel(�Ϲ�) / gettr&setter
import strategy2_interfaces.*;

public class Genesis extends Car {
	public  Genesis() {
		setEngine(new EngineHigh());
		setKm(new Km10());
		setFuel(new FuelGasoline());
	}
	
	@Override
	public void shape() {
		System.out.println("���׽ý� ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
