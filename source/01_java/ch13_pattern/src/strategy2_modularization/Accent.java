package strategy2_modularization;
// ��ӹ��� ��� : // 3���� ��ǰ ����  /������ X / �޼ҵ�O drive(�Ϲ�), shape(�߻�), engine(�Ϲ�), km(�Ϲ�) fuel(�Ϲ�) / gettr&setter
import strategy2_interfaces.*;

public class Accent extends Car {
	public  Accent() {
		setEngine(new EngineLow());
		setKm(new Km10());
		setFuel(new FuelDiesel());
	}
	
	@Override
	public void shape() {
		System.out.println("�׼�Ʈ ����� door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}

}
