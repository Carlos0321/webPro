package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("박보검");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		System.out.println("-----------------------");
		IChef chefPark = new Actor("박셰프");
//		chefPark.canCatchCriminal()불가  다른 인터페이스는 사욜불가 
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		System.out.println("-----------------------");
		IFireFighter firePark = new Actor("박");
		firePark.outFire();
		firePark.saveMan();
		System.out.println("-----------------------");
		IPoliceMan policePark = new Actor("박경관");
		policePark.canCatchCriminal();
		policePark.canSearch();
	}

}
