package strategy2_interfaces;

public class FuelDiesel implements IFuel {

	@Override
	public void fuel() {
		System.out.println("경유 차량입니다");
	}

}
