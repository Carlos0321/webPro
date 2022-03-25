package strategy2_interfaces;

public class FuelGasoline implements IFuel {

	@Override
	public void fuel() {
		System.out.println("휘발유 차량입니다");
	}

}
